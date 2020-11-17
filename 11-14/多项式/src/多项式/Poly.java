package ����ʽ;
//����ʽ��
public class Poly {
	final int NMAX = 1000;	//����ʽ���������
	int nItem;	//����ʽ������
	Node[] Item;	//����ʽ�ĸ���
	
	//ȱʡ���캯��,�����ʽ
	public Poly() {
		this.nItem = 1;
		Item = new Node[NMAX];
		for (int i = 0; i < NMAX; i++)
			Item[i] = new Node();
	}

	//�������Ĺ��캯��
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

	//����ʽ�ӷ����豾����ʽΪA����A=A+B
	public void Subtraction(Poly B) {
		int n1,n2;  //����ʽA��B������
		int p,q,r;  //�ֱ�ָ�����ʽA��B��C�����ָ��

		int[]	AC = new int[NMAX];
		int[]	AE = new int[NMAX];
		int[]	BC = new int[NMAX];
		int[]	BE = new int[NMAX];
		int[]	CC = new int[NMAX];
		int[]	CE = new int[NMAX];

		//����A��
		n1 = this.nItem;
		for (int i = 0; i < n1; i++)
		{
			AC[i] = this.Item[i].coef;
			AE[i] = this.Item[i].exp;
		}

		//����B��
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
				
		if (r == 0)	//�����ʽ
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