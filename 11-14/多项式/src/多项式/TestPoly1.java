package 多项式;
//设计一个一元稀疏多项式简单的加减法计算器。输入时要确保项的指数已按升序排序。
import java.util.*;

public class TestPoly1 {
	public static void main(String[] args)	{
		final int NMAX = 1000;	//多项式的最大项数
		int n1,n2;  //多项式A和B的项数
		int t = 0;  //Case no.

		int[]	AC = new int[NMAX];
		int[]	AE = new int[NMAX];
		int[]	BC = new int[NMAX];
		int[]	BE = new int[NMAX];

		  Scanner in = new Scanner(System.in);

		   for (;;)
		  {
			//读入A，B：
			n1 = in.nextInt();
			if (n1 <= 0)
				break;
			     for (int i = 0; i < n1; i++)
			     {
				AC[i] = in.nextInt();
				AE[i] = in.nextInt();
			 }

			n2 = in.nextInt();
			for (int i = 0; i < n2; i++){
				
				BC[i] = in.nextInt();
				BE[i] = in.nextInt();
			}

			//生成A，B：
			Poly A = new Poly(n1,AC,AE);
			Poly B = new Poly(n2,BC,BE);

			//A=A-B:
			A.Subtraction(B);

			//输出C(=A)：
			++t;
			System.out.println("Case "+t+":");	
			
			for (int i = 0; i < A.nItem; i++) {
				if(A.Item[i].exp==0) 
				{
					System.out.print(""+A.Item[i].coef);
				}
				else if(A.Item[i].exp==1)
              {
					System.out.print(""+A.Item[i].coef+"x");
              }
				else if(A.Item[i].coef>0){
				System.out.print("+"+A.Item[i].coef+"x^"+A.Item[i].exp);
			}
				else
					System.out.print(""+A.Item[i].coef+"x^"+A.Item[i].exp);
		}
			System.out.println("\n");}
		
     }
}