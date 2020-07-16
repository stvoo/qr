package qr_govyaha;

public class split_str {
	public static void main(String args[]) {
        String Str = new String("Скинь сиськи, пожалуйста.");
        
        System.out.println("Разделенные строки: ");
        String[] query = Str.split(" ");
        String str_1 = query[0];
        String str_2 = query[1];
        String str_3 = query[2];
            System.out.println(str_1);
            System.out.println(str_2);
            System.out.println(str_3);
        
        
	}
}