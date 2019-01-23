package LeetcodePrograms;

/**
 * Created by rkhurana on 1/20/19.
 */
public class reformatPhoneNumber {
    public void Reformat(String []phoneNumbers){
        for (String phoneNumber : phoneNumbers){

            String first = null;
            String second = null;
            String third = null;
            if(phoneNumber.length() != 10){
                 first = phoneNumber.substring(0,3);
                 second = phoneNumber.substring(4,7);
                 third = phoneNumber.substring(8,12);
            }
            else{
                first = phoneNumber.substring(0,3);
                second = phoneNumber.substring(3,6);
                third = phoneNumber.substring(6,10);

            }
            System.out.println(first);
            System.out.println(second);
            System.out.println(third);

        }
    }
    public static void main(String[] args){
        reformatPhoneNumber phoneNumber = new reformatPhoneNumber();
        String str[]={"1234567890","abc-def-ghij"};
        phoneNumber.Reformat(str);
    }
}
