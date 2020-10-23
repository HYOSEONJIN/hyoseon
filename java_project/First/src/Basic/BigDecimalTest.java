package Basic;

import java.math.BigDecimal;

public class BigDecimalTest {

	public static void main(String[] args) {

		
		double d1= 1.6;
		double d2= 0.1;
		System.out.println("d1 : " + d1);
		System.out.println("d2 : " + d2);
		System.out.println("d1 + d2 : "+ (d1+d2));
		System.out.println("d1 * d2 : "+ (d1*d2));
		
		BigDecimal e1 = new BigDecimal("1.6");
		BigDecimal e2 = new BigDecimal("0.1");
		
		System.out.println("두 실수의 덧셈결과: "+ e1.add(e2));
		System.out.println("두 실수의 곱셈결과: "+ e1.multiply(e2));
	}

}
