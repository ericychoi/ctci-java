// 17.7
public class IntToWords {

  final static String[] delim = {" Thousand,", " Million,", " Billion,"};
  final static String[] digit = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"};
  final static String[] teen = {" Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
  final static String[] ties = {"", "", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninty"};

  public static void main(String[] args) {
    int in = 2052101120;
    System.out.println(in + "\n" + convert(in, 0));
    in = 2052012113;
    System.out.println(in + "\n" + convert(in, 0));
    in = 9200690;
    System.out.println(in + "\n" + convert(in, 0));

  }

  static String convert(int in, int thousands) {
    if (in < 1000) {
      return convertThreeDigits(in);
    }
    else {
      String d = delim[thousands];
      return convert(in/1000, thousands+1) + d + convert(in%1000, thousands+1);
    }
  }

  static String convertThreeDigits(int in) {
    String result = "";
    String h = digit[in/100];
    if (h != "") h += " Hundred";
    if ((in%100)/10 ==1) {
      return h + teen[in%100-10];
    }

    result = h + ties[(in%100)/10] + digit[in%10];
    return result;
  }
}
