package Test;

public class Comment {
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int floor;
	private String comment;
   public Comment(int i,String str) {
	   super();
	   floor=i;
	   comment=str;
   }
   public String getcomment() {
		return comment;
	}
   public int getfloor() {
	   return floor;
   }
   public void setcomment(String str) {
	   comment=str;
   }
}
