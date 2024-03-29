package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy {

	public static void main(String[] args) throws IOException {

		// 읽어올 대상 파일의 InputStream 인스턴스를 생성한다.

		InputStream in = new FileInputStream("org.pdf");

		// 출력 대상 파일의 OutpurStream 인스턴스 생성

		OutputStream out = new FileOutputStream("org_copy.pdf");

		// 필터스트림 인스턴스 생성
		BufferedInputStream bin = new BufferedInputStream(in, 1024 * 3);
		BufferedOutputStream bout = new BufferedOutputStream(out, 1024 * 3);

		int copyByte = 0; // 복사한 사이즈
		int bData = 0; // 원본에서 복사한 byte 사이즈의 데이터

		System.out.println("복사를 시작합니다.");

		while (true) {
			bData = in.read(); // 더이상 가져올 데이터가 없으면 -1을 반환

			if (bData == -1) {

				break;
			}
			out.write(bData); // 출력 : 파일에 바이터리 코드를 쓴다.
			copyByte++;
		}

		in.close(); // 스트림 인스턴스 소멸
		out.close();
		System.out.println("복사가 완료되었습니다.");
		System.out.println("복사된 사이즈 : " + copyByte + "byte");
	}
}
