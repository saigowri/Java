import java.util.Scanner;

public class UserMain {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		String nam,v;
		System.out.println("Enter name of your grandparent");
		nam = sc.next();
		BinTree bt = new BinTree(nam);
		
		System.out.println("Enter name of your parent");
		nam = sc.next();
		bt.setLeft(new BinTree(nam));
						
		System.out.println("Enter name of your aunt/uncle");
		nam = sc.next();
		bt.setRight(new BinTree(nam));
		
		System.out.println("Enter name of your sibling");
		nam = sc.next();
		bt.left.setLeft(new BinTree(nam));
		
		System.out.println("Enter your name");
		nam = sc.next();
		bt.left.setRight(new BinTree(nam));
		
		System.out.println("Enter name of your cousin");
		nam = sc.next();
		bt.right.setLeft(new BinTree(nam));
		
		System.out.println("Enter name of your other cousin");
		nam = sc.next();
		bt.right.setRight(new BinTree(nam));		
		
		int choice = 0;
		while(true) {
			System.out.println("Enter your choice: \n 1. Number of people in family tree \n 2. Find someone in family tree \n 3. Check if two people are siblings \n 4. Check if two people are cousins \n 5. Check if one person is a descendent of another \n 6. Find closest common ancestor \n 7. Exit");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1: System.out.println("Number of people in the family tree are " + BinTree.getNumberOfNodes());
					break;
				case 2: System.out.println("Enter the name of the person you want to find");
					nam = sc.next();
					if(bt.find(nam)==0)
						System.out.println(nam + " is present in the family tree");
					else
						System.out.println(nam + " is not present in the family tree");
					break;
				case 3: System.out.println("Enter the name of the two people");
					nam = sc.next();
					String nam1 = sc.next();
					if(bt.isSibling(nam,nam1)==0)
						System.out.println(nam + " and " + nam1 + "are siblings");
					else
						System.out.println(nam + " and " + nam1 + "are not siblings");
					break;
				case 4: System.out.println("Enter the name of the two people");
					nam = sc.next();
					nam1 = sc.next();
					if(bt.isCousin(nam,nam1))
						System.out.println(nam + " and " + nam1 + "are cousins");
					else
						System.out.println(nam + " and " + nam1 + "are not cousins");
					break;
				case 5: System.out.println("Enter the name of the older person");
					nam = sc.next();
					System.out.println("Enter the name of the younger person");
					nam1 = sc.next();
					if(bt.isDescendent(nam,nam1)==0)
						System.out.println(nam1 + " is the descendent of " + nam);
					else
						System.out.println(nam1 + " is not the descendent of " + nam);
					break;
				case 6: 
					System.out.println("Enter the name of the older person");
					nam = sc.next();
					System.out.println("Enter the name of the younger person");
					nam1 = sc.next();
					if((v = bt.getCommonAncestor(nam, nam1))!=null)
						System.out.println(bt.getCommonAncestor(nam, nam1)+" is the closest common ancestor");
					else
						System.out.println("There exist no common ancestors.");
				case 7: System.exit(0);
				default: System.out.println("Wrong choice. Enter again.");
					 break;
			}
		}
	}
}
