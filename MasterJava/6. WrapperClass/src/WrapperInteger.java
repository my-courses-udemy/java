public class WrapperInteger {

    public static void main(String[] args) {

        int primitive = 356424;
        // this is boxing, work with primitive or attribute
        Integer intObject = Integer.valueOf(primitive);
        Integer intObject2 = 235;

        // There are two ways
        int intConverted = intObject;
        System.out.println("intConverted = " + intConverted);
        // unboxing
        int numberConverted2 = intObject2.intValue();
        System.out.println("numberConverted2 = " + numberConverted2);

        // convert String to numeric value
        String numberString = "43553";
        Integer value = Integer.valueOf(numberString);
        System.out.println("value = " + value);

        Short objectShort = intObject.shortValue();
        System.out.println("objectShort = " + objectShort);

    }

}
