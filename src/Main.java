import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static String fileName;
    public static int k;
    public static FileReader reader;
    public static char c;
    public static String token = new String();
    public static String[] strings = {
            "Begin",
            "End",
            "For",
            "If",
            "Then",
            "Else",
            "Colon",
            "Plus",
            "Star",
            "Comma",
            "LParenthesis",
            "RParenthesis",
            "Assign",
            "Unknown"
    };
    public static void main(String[] args) {
        fileName = args[0];
        k = 0;
        c = 0;
//        System.out.println(removeZero("0001"));
        try {
            reader = new FileReader(fileName);
            fun();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fun() throws IOException {
        while(true) {
            token = new String();
            try {
                getNBC();
                if((int)c == -1 || c == '\uFFFF'){
                    reader.close();
                    return;
                }

                if (isLetter()) {
                    while (isLetter() || isDigital()) {
                        token += c;
                        getChar();
                    }
                    int k = reserve();
                    if (k == 0)
                        System.out.println("Ident(" + token + ")");
                    else
                        System.out.println(strings[k - 1]);
                } else if (isDigital()) {
                    while (isDigital()) {
                        token += c;
                        getChar();
                    }
                    System.out.println("Int(" + removeZero(token) + ")");
                } else {
                    switch (c) {
                        case ':':
                            getChar();
                            if(c == '='){
                                System.out.println(strings[12]);
                            }
                            else
                                System.out.println(strings[6]);
                            getChar();
                            break;
                        case '+':
                            System.out.println(strings[7]);
                            getChar();
                            break;
                        case '*':
                            System.out.println(strings[8]);
                            getChar();
                            break;
                        case ',':
                            System.out.println(strings[9]);
                            getChar();
                            break;
                        case '(':
                            System.out.println(strings[10]);
                            getChar();
                            break;
                        case ')':
                            System.out.println(strings[11]);
                            getChar();
                            break;
//                        case '\n' :
//                        case '\r' :
//                            break;
//                        case '\uFFFF':
//                            return ;
                        default:
                            System.out.println(strings[13]);
                            reader.close();
                            return;
                    }
                }
            }
            catch (Exception e){
                reader.close();
                return;
            }
        }

    }

    public static String removeZero(String str) {
        int len = str.length(), i = 0;
        while (i < len && str.charAt(i) == '0') {
            i++;
        }
        return str.substring(i);
    }

    public static boolean isLetter(){
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }

    public static boolean isDigital(){
        return '0' <= c && c <= '9';
    }

    public static boolean isOtherThing(){
        return (c == ' ' || c == '\n' || c == '\r');
    }

    public static int reserve(){
        switch (token){
            case "BEGIN" :
                return 1;
            case "END" :
                return 2;
            case "FOR" :
                return 3;
            case "IF" :
                return 4;
            case "THEN" :
                return 5;
            case "ELSE" :
                return 6;
            default:
                return 0;
        }

    }


    public static void getChar() throws IOException {
        c = (char)reader.read();
    }

    public static void getNBC() throws IOException {
        if(!isOtherThing() && c != 0)
            return;
        do{
            getChar();
        }
        while(isOtherThing());
    }

    public static void readMethod1()
    {
        String fileName="C:/kuka.txt";
        int c=0;
        try
        {
            FileReader reader=new FileReader(fileName);
            c=reader.read();
            while(c!=-1)
            {
                System.out.print((char)c);
                c=reader.read();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
