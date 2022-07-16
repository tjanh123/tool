package org.ttrung.mai.tool;

import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		int limit = 3;
		/*int pos = -1;
		int stage2 = -2;
		int stage1 = 1;
		
		for (int i = 3; i <= limit; i++) {
			int stage_n = stage2 - stage1;
			pos += stage_n;
			
			stage1 = stage2;
			stage2 = stage_n;
		}*/
		
//		System.out.println("ddd " + limit + " --- " + pos);
		System.out.println("ddd " + limit + " --- " + calculate(limit));

	}

	public static int calculate( int iterationNumber )
	   {
	      int position = 0;
	      int step1 = 1;
	      position = position + step1;
	      iterationNumber -= 1;
	      
	      int step2 = -2;
	      position = position + step2;
	      iterationNumber -= 1;
	      
	      while( iterationNumber > 0 )
	      {
	         position +=  ( step2 - step1 );
	         int buffer = step1;
	         step1 = step2;
	         step2 = step2 - buffer;
	         iterationNumber -= 1;
	      }
	      return position;
	   }
}
