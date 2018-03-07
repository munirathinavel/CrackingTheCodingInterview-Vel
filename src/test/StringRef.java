package test;
public class StringRef 
{
    public static void main(String [] args) 
    {
        String s1 = "abc";
        String s2 = "def";
        String s3 = s2;   /* Line 7 */
        s2 = "ghi";
        System.out.println(s1 + s2 + s3);
        
        String x = "xyz";
        x.toUpperCase(); /* Line 2 */
        String y = x.replace('Y', 'y');
        y = y + "abc";
        System.out.println(y);
    }
}