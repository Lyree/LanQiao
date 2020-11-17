package 多项式;
//多项式类
public class Poly {
	final int NMAX = 1000;	//多项式的最大项数
	int nItem;	//多项式的项数
	Node[] Item;	//多项式的各项
	
	//缺省构造函数,零多项式
	public Poly() {
		this.nItem = 1;
		Item = new Node[NMAX];
		for (int i = 0; i < NMAX; i++)
			Item[i] = new Node();
	}

	//带参数的构造函数
	public Poly(int nItem,int c[],int e[]) {
		this.nItem = nItem;
		Item = new Node[NMAX];

		for (int i = 0; i < NMAX; i++)
		{
			if (i < nItem)
				Item[i] = new Node(c[i],e[i]);
			else
				Item[i] = new Node();
		}
	}

	//多项式加法。设本多项式为A，则A=A+B
	public void Subtraction(Poly B) {
		int n1,n2;  //多项式A和B的项数
		int p,q,r;  //分别指向多项式A、B、C的项的指针

		int[]	AC = new int[NMAX];
		int[]	AE = new int[NMAX];
		int[]	BC = new int[NMAX];
		int[]	BE = new int[NMAX];
		int[]	CC = new int[NMAX];
		int[]	CE = new int[NMAX];

		//读出A：
		n1 = this.nItem;
		for (int i = 0; i < n1; i++)
		{
			AC[i] = this.Item[i].coef;
			AE[i] = this.Item[i].exp;
		}

		//读出B：
		n2 = B.nItem;
		for (int i = 0; i < n2; i++)
		{
			BC[i] = B.Item[i].coef;
			BE[i] = B.Item[i].exp;
		}

		//C = A-B:
		for (p = q = r = 0; p < n1 && q < n2;)
		{
			if (AE[p] < BE[q])
			{
				CC[r] = AC[p];
				CE[r] = AE[p];
				p++;
				r++;
			}
			else if (AE[p] > BE[q])
			{
				CC[r] -= BC[q];
				CE[r] = BE[q];
				q++;
				r++;
			}
			else
			{
				CC[r] = AC[p] - BC[q];
				CE[r] = AE[p];
				p++;
				q++;
				if (CC[r] != 0)
					r++;
			}
		}

		if (p < n1 && q >= n2)
		{
			for (; p < n1;)
			{
				CC[r] = AC[p];
				CE[r] = AE[p];
				p++;
				r++;
			}
		}
		else if (p >= n1 && q < n2)
		{
			for (; q < n2;)
			{
				CC[r] -= BC[q];
				CE[r] = BE[q];
				q++;
				r++;
			}
		}
				
		if (r == 0)	//零多项式
		{
			CC[r] = 0;
			CE[r] = 0;
			r++;
		}

		//A=C:
		this.nItem = r;
		for (int i = 0; i < r; i++)
		{
			this.Item[i].coef = CC[i];
			this.Item[i].exp = CE[i];
		}
	}
}