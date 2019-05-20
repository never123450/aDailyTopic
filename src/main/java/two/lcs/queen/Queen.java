package two.lcs.queen;


public class Queen {
	public static int num = 0;//�ۼƷ���
	public static final int MAXQUEEN = 8;
	public static int[] cols = new int[MAXQUEEN];//����cols���飬��ʾ8�����ӻʺ�ڷŵ�λ��
	
	/**
	 * 
	 * @param n   ���n�еĻʺ�
	 */
	public void getCount(int n){
		boolean [] rows = new boolean[MAXQUEEN];//��¼ÿ��ÿ�������Ƿ���ԷŻʺ�
		for(int m = 0;m<n;m++){
			rows[cols[m]] = true;
			int d = n - m;//б�Խ�
			//��б����
			if(cols[m]-d>=0){
				rows[cols[m] -d] = true;
			}
			//��б����
			if(cols[m]+d<=(MAXQUEEN-1)){
				rows[cols[m]+d] = true;
			}
		}
		//����֪������Щλ�ò��ܷŻʺ�
		for(int i = 0;i<MAXQUEEN;i++){
			if(rows[i]){
				//���ܷ�
				continue;
			}
			cols[n] = i;
			if(n<MAXQUEEN-1){
				getCount(n+1);
			}else{
				//�ҵ�������һ�׷���
				num++;
				printQueen();
			}
			//���������Ȼ�кϷ�λ��
		}
	}

	private void printQueen() {
		System.out.println("��"+num+"�ַ���");
		for(int i = 0;i<MAXQUEEN;i++){
			for(int j = 0;j<MAXQUEEN;j++){
				if(i == cols[j]){
					System.out.print("0 ");
				}else{
					System.out.print("+ ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		Queen queen = new Queen();
		queen.getCount(0);
	}
}
