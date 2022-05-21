import java.lang.reflect.Field;
  
public class GFG {
  
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, SecurityException
    {
  
        // create attributes object
        attributes att = new attributes();
  
        // Get the value field object
        Field field1
            = attributes.class
                  .getField("bolValue");
        Field field2
            = attributes.class
                  .getField("intValue");
        Field field3
            = attributes.class
                  .getField("doubleValue");
  
        // Apply set Method
        field1.set(att, false);
        field2.set(att, 1213);
        field3.set(att, 342414.131);
  
        // print value of isActive
        System.out.println(
            "Values after "
            + "applying set are { "
            + att.bolValue + ", "
            + att.intValue
            + ", " + att.doubleValue
            + " }.");
    }
}
  
// sample attributes class
class attributes {
  
    // static value value
    public static boolean bolValue = false;
    public static int intValue = 13134;
    public static double doubleValue = 1314.141;
}