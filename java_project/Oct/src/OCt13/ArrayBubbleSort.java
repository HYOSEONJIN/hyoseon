package OCt13;

public class ArrayBubbleSort {

	public static void main(String[] args) {

		// 정수 데이터 10개를 저장하는 배열 생성
		int[] number = new int[10];

		// 임의의 숫자 0~9까지의 숫자를 각 배열에 넣기
		for (int i = 0; i < number.length; i++) {
			number[i] = (int) (Math.random() * 10);
			System.out.print(number[i] + " ");
		}

		System.out.println();
		System.out.print("====================");
		System.out.println();
		
		for (int i = 0; i < number.length; i++) {
			boolean changed = false; // 자리바뀜이 발생했는지 체크

			// 자리를 바꿈처리
			for (int j = 0; j < number.length - 1 - i; j++) {
				// 왼쪽 인덱스의 값과 오른쪽 인덱스의 값을 비교
				if (number[j] > number[j + 1]) {
					int temp = number[j];
					number[j] = number[j + 1];
					number[j + 1] = temp;
					changed = true;
				}

			}

			for (int a : number) {
				System.out.print(a + " ");
			}
			System.out.println();

			if (!changed) {
				System.out.println("=======================");
				break;
			}

		}

		for (int a : number) {
			System.out.print(a + " ");
		}

	}

}
