import java.util.*;
class coursework {

	public static String[] studentIdArray = new String[0];
	public static String[] studentNameArray = new String[0];
	public static int[] prfMarksArray = new int[0];
	public static int[] dbmMarksArray = new int[0];
	public static String sid="";
	public static int[] studentTot;
	public static double[] studentAvg;
	public static int[] studentRank;
	
	public static void title(String t){
		int len=78,x,y;
		x=(len-t.length())/2;
		if(t.length()%2==1){
			y=x+1;
		}else{
			y=x;
		}
		System.out.println("+------------------------------------------------------------------------------+");
		System.out.printf("|%"+x+"s%s%"+y+"s|\n","",t,"");
		System.out.println("+------------------------------------------------------------------------------+\n\n");
	}
	
	public final static void clearConsole() {
			try {
				final String os = System.getProperty("os.name");
				if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
				}
			} catch (final Exception e) {
			e.printStackTrace();
			// Handle any exceptions.
			}
		}
		
	public static boolean isDuplicate(String[]a,String key){
		for (int i = 0; i < a.length; i++){
			if(a[i].equals(key)){
				return true;
			}
		}
		return false;
	}

	public static int search(String[] a,String s){
		for (int i = 0; i < a.length; i++){
			if(a[i].equals(s)){
				return i;
			}
		}
		return -1;
	}
		
	public static int checkSId(){
		Scanner input=new Scanner(System.in);
		L1:while(true){
			System.out.print("\nEnter student ID : ");
			sid=input.next();
			int i=search(studentIdArray,sid);
			
				if(i==-1){
					System.out.print("Invalid Student ID. Do you want to search again? (Y/n) : ");
					String ans=input.next();
						if(ans.equals("y") || ans.equals("Y")){
							continue L1;
						}else{
							return -1;
						}
				}
				return i;
		}	
	}
			
	public static void homePage(){
			Scanner input=new Scanner (System.in);
			
			int optionNumber;
			title("WELCOME TO GDSE MARKS MANAGEMENT SYSTEM");
			System.out.print("\n[1] Add New Student\t\t\t\t\t[2] Add New Student With Marks");
			System.out.print("\n[3] Add Marks      \t\t\t\t\t[4] Update Student Details ");
			System.out.print("\n[5] Update Marks   \t\t\t\t\t[6] Delete Student ");
			System.out.print("\n[7] Print Student Details\t\t\t\t[8] Print Student Ranks ");
			System.out.print("\n[9] Best in programming Fundamentals\t\t\t[10] Best in Database Management System ");
			System.out.println("\n");
			
				
			System.out.print("Enter an option to continue > ");
			optionNumber=input.nextInt();
				switch(optionNumber){
					case 1 : clearConsole();addNewStudent();break;
					case 2 : clearConsole();addNewStudentWithMarks();break;
					case 3 : clearConsole();addMarks();break;
					case 4 : clearConsole();updateStudentDetails();break;
					case 5 : clearConsole();updateMarks();break;
					case 6 : clearConsole();deleteStudent();break;
					case 7 : clearConsole();printStudentDetails();break;
					case 8 : clearConsole();printStudentRanks();break;
					case 9 : clearConsole();bestInPrf(prfMarksArray,dbmMarksArray);break;
					case 10 : clearConsole();bestInDbm(dbmMarksArray,prfMarksArray);break;
				}
			clearConsole();
			

		}
	
	public static void addNewStudent(){
			Scanner input = new Scanner (System.in);
				title("ADD NEW STUDENT");
				L1:while (true){
				System.out.print("Enter Student ID : ");
				String tempId = input.next();
				char id = tempId.charAt(0);
				if(id!='S' ||tempId.length()!=4){
				L:while(true){
					System.out.print ("\nInvalid Student ID.Do you want to enter again?(Y/N) : ");
					String op =input.next();
				
				
					if (op.equals("y") || op.equals("Y")){
					clearConsole();
					addNewStudent();
					}else if (op.equals("n") || op.equals("N")){
					clearConsole();
					homePage();
					}else{
					System.out.println("Wrong Option.Pick Again\n");
					continue L;
					}
					}
				}
				if(isDuplicate(studentIdArray,tempId)){
				
				System.out.println("The Student Id is Alreday Exists.\n");
				continue L1;
				
				}
				
				String[] tempStudentId =new String[studentIdArray.length+1];
			
				for(int i = 0; i < studentIdArray.length; i++){
						tempStudentId[i] =studentIdArray[i];	
				}
				studentIdArray=tempStudentId;
				studentIdArray[studentIdArray.length-1]=tempId;
			
			
				
			input.nextLine();		
			System.out.print("Enter Student Name : ");
			String tempName = input.nextLine();
			String[] tempStudentName =new String[studentNameArray.length+1];
				for (int i = 0; i < studentNameArray.length; i++){	
						tempStudentName[i] = studentNameArray[i];	
				}
				studentNameArray=tempStudentName;
				studentNameArray[studentNameArray.length-1]=tempName;
						
					int[] tempPrfMarks =new int[prfMarksArray.length+1];
						for (int i = 0; i < prfMarksArray.length; i++){	
							tempPrfMarks[i] = prfMarksArray[i];	
						}
						prfMarksArray=tempPrfMarks;
						prfMarksArray[prfMarksArray.length-1]=-1;
						
						int[] tempDbmMarks =new int[dbmMarksArray.length+1];
						for (int i = 0; i < dbmMarksArray.length; i++){	
							tempDbmMarks[i] = dbmMarksArray[i];	
						}
						dbmMarksArray=tempDbmMarks;
						dbmMarksArray[dbmMarksArray.length-1]=-1;
			L3:while(true){
			System.out.print("Student Has been added successfully.Do you want to add a new student(Y/N) : ");
			String option =input.next();
			
				if (option.equals("y") || option.equals("Y")){
				clearConsole();
				addNewStudent();
				}else if (option.equals("n") || option.equals("N")){
				clearConsole();
				homePage();
				}else{
				System.out.println("Wrong Option.Pick Again\n");
				continue L3;
				}
			}
		
			
		}
			}
			
	public static void addNewStudentWithMarks(){
				
			Scanner input = new Scanner (System.in);
				title("ADD NEW STUDENT WITH MARKS");
				L1:while (true){
				System.out.print("Enter Student ID : ");
				String tempId = input.next();
				char id = tempId.charAt(0);
				if(id!='S' ||tempId.length()!=4){
				L:while(true){
				System.out.print ("\nInvalid Student ID.Do you want to enter again?(Y/N) : ");
				String op =input.next();
				
				if (op.equals("y") || op.equals("Y")){
				clearConsole();
				addNewStudentWithMarks();
				}else if (op.equals("n") || op.equals("N")){
				clearConsole();
				homePage();
				}else{
					System.out.println("Wrong Option.Pick Again\n");
					continue L;
				}
				}
					
				}
				if(isDuplicate(studentIdArray,tempId)){
				
				System.out.println("The Student Id is Alreday Exists.\n");
				continue L1;
				
				}
				
				String[] tempStudentId =new String[studentIdArray.length+1];
			
				for(int i = 0; i < studentIdArray.length; i++){
						tempStudentId[i] =studentIdArray[i];	
				}
				studentIdArray=tempStudentId;
				studentIdArray[studentIdArray.length-1]=tempId;
			
			
				
			input.nextLine();		
			System.out.print("Enter Student Name : ");
			String tempName = input.nextLine();
			String[] tempStudentName =new String[studentNameArray.length+1];
				for (int i = 0; i < studentNameArray.length; i++){	
						tempStudentName[i] = studentNameArray[i];	
				}
				studentNameArray=tempStudentName;
				studentNameArray[studentNameArray.length-1]=tempName;
				
					
					
					
					L2:while(true){
					System.out.println("\n");
					System.out.print("Progrmming Fundamental Marks : ");
					int tempPrf = input.nextInt();	
					
					if (tempPrf > 100 || tempPrf < 0){
					System.out.println("Invalid Marks,Please Enter Correct Marks.");
					continue L2;
					}
					
					
					int[] tempPrfMarks =new int[prfMarksArray.length+1];
						for (int i = 0; i < prfMarksArray.length; i++){	
							tempPrfMarks[i] = prfMarksArray[i];	
						}
						prfMarksArray=tempPrfMarks;
						prfMarksArray[prfMarksArray.length-1]=tempPrf;
					L3:while(true){
					
					System.out.print("Database Management System Marks : ");
					int tempDbm = input.nextInt();		
						
					if (tempDbm > 100 || tempDbm < 0){
					System.out.println("Invalid Marks,Please Enter Correct Marks.");
					continue L3;
					}
						
						int[] tempDbmMarks =new int[dbmMarksArray.length+1];
						for (int i = 0; i < dbmMarksArray.length; i++){	
							tempDbmMarks[i] = dbmMarksArray[i];	
						}
						dbmMarksArray=tempDbmMarks;
						dbmMarksArray[dbmMarksArray.length-1]=tempDbm;
			L4:while(true){
			System.out.print("Student Has been added successfully.Do you want to add a new student(Y/N) : ");
			String option =input.next();
			if (option.equals("y") || option.equals("Y")){
			clearConsole();
			addNewStudentWithMarks();
			}else if (option.equals("n") || option.equals("N")){
			clearConsole();
			homePage();
			}else{
				System.out.println("Wrong Option.Pick Again\n");
				continue L4;
			}
			
			}
		}
	}
			
		}
			}
				
	public static void addMarks(){
		Scanner input = new Scanner (System.in);
		title("ADD MARKS");
		int i=checkSId();
		if(i==-1){
			clearConsole();
			homePage();
		}
		System.out.println("Student Name     : "+studentNameArray[i]);
		if(prfMarksArray[i]!=-1){
			System.out.println("This student's marks have been already added.\nIf you want to update the marks, please use [5] Update Marks option.\n");
		}else{
			System.out.println();
			prfMarksArray[i]=addPrfMarks();
			dbmMarksArray[i]=addDbmMarks();
			System.out.print("Marks have been added. ");
		}
		L:while(true){
		System.out.print("Do you want to add marks for another student? (Y/n) : ");
		String ans=input.next();
		
		if(ans.equals("y") || ans.equals("Y")){
			clearConsole();
			addMarks();
		}else if (ans.equals("n") || ans.equals("N")){
			clearConsole();
			homePage();
			
		}else{
			System.out.println("Wrong Option.Pick Again\n");
			continue L;
		}
		
		}
		}		
					
	public static int addPrfMarks(){
		Scanner input=new Scanner(System.in);
		while(true){
			System.out.print("Programming Fundamental Marks : ");
			int prfm=input.nextInt();
			if(prfm<0 || prfm>100){
				System.out.println("Invalid marks, please enter correct marks.");
				continue;
			}
			return prfm;
		}
	}
	
	public static int addDbmMarks(){
		Scanner input=new Scanner(System.in);
		while(true){
			System.out.print("Database Managenment System Marks : ");
			int dbmm=input.nextInt();
			if(dbmm<0 || dbmm>100){
				System.out.println("Invalid marks, please enter correct marks.\n");
				continue;
			}
			return dbmm;
		}
	}
				
	public static void updateStudentDetails(){
				Scanner input = new Scanner (System.in);
				title("UPDATE STUDENT Details");
				int i=checkSId();
				if(i==-1){
				clearConsole();
				homePage();
				}
		System.out.println("Student Name     : "+studentNameArray[i]);
		System.out.print("\nEnter the new student name: ");
		String name=input.nextLine();
		studentNameArray[i]=name;
		System.out.println("\nStudent details has been updated successfuly.");
		L:while(true){
		System.out.print("Do you want to update another student details? (Y/n): ");
		String ans=input.next();
		clearConsole();
		if(ans.equals("y") || ans.equals("Y")){
			updateStudentDetails();
		}else if (ans.equals("n") || ans.equals("N")){
		clearConsole();
		homePage();
		}else{
				System.out.println("Wrong Option.Pick Again\n");
				continue L;
		}
		}
		}

	public static void updateMarks(){
				Scanner input=new Scanner(System.in);
				title("UPDATE MARKS");
				int i=checkSId();
				if(i==-1){
				clearConsole();
				homePage();
		}
		System.out.println("Student Name     : "+studentNameArray[i]);
		if(prfMarksArray[i]==-1){
			System.out.println("\nThis student's marks yet to be added.");
		}else{
			System.out.println("\nProgramming Fundamentals Marks   : "+prfMarksArray[i]);
			System.out.println("Database Management System Marks : "+dbmMarksArray[i]);
			System.out.print("\nEnter new ");
			prfMarksArray[i]=addPrfMarks();
			System.out.print("Enter new ");
			dbmMarksArray[i]=addDbmMarks();
		}
		L:while(true){
		System.out.print("Do you want to update marks for another student? (Y/n): ");
		String ans=input.next();
		clearConsole();
		if(ans.equals("y") || ans.equals("Y")){
			updateMarks();
		}else if (ans.equals("n") || ans.equals("N")){
		clearConsole();
		homePage();
		}else{
			System.out.println("Wrong Option.Pick Again\n");
			continue L;
		}
		}
		}
				
	public static void deleteStudent(){
				Scanner input =new Scanner(System.in);
				title("DELETE STUDENT");
				int i=checkSId();
				if(i==-1){
				clearConsole();
				homePage();
				}
				studentIdArray=deleteIndex(studentIdArray,i);
				studentNameArray=deleteIndex(studentNameArray,i);
				prfMarksArray=deleteIndex(prfMarksArray,i);
				dbmMarksArray=deleteIndex(dbmMarksArray,i);
			System.out.println("Student has been deleted successfully.");
		L:while(true){
		System.out.print("Do you want to delete another student? (Y/n): ");
		String op=input.next();
		clearConsole();
		if(op.equals("y") || op.equals("Y")){
			deleteStudent();
		}else if (op.equals("n") || op.equals("N")){
		clearConsole();
		homePage();
		}else{
			System.out.println("Wrong Option.Pick Again\n");
			continue L;
		}
		}
		}
	
	public static String[] deleteIndex(String[] s,int in){
			String[] temp=new String[s.length-1];
			for (int i = 0,j=0; j < temp.length; i++,j++){
				if(i==in && in!=s.length-1){
					i++;
				}
				temp[j]=s[i];
			}
			return temp;
	}
	
	public static int[] deleteIndex(int[] s,int in){
		int[] temp=new int[s.length-1];
		for (int i = 0,j=0; j < temp.length; i++,j++){
			if(i==in && in!=s.length-1){
				i++;
			}
			temp[j]=s[i];
		}
		return temp;
	}
	
	public static void findTotAvg(){
		studentTot=new int[studentIdArray.length];
		studentAvg=new double[studentIdArray.length];
		for (int i = 0; i < studentIdArray.length; i++){
			studentTot[i]=prfMarksArray[i]+dbmMarksArray[i];
			studentAvg[i]=studentTot[i]/2d;
		}
	}
	
	public static int[] findRank(int[] a){
		int[] temp=new int[studentIdArray.length];
		int[] rank=new int[studentIdArray.length];
		for (int i = 0; i < studentIdArray.length; i++){
			temp[i]=a[i];
			rank[i]=i;
		}
		for (int i = studentIdArray.length-1; i > 0; i--){
			for(int j=1; j<=i; j++){
				if(temp[j-1]<temp[j]){
					int t=temp[j-1];
					int in=rank[j-1];
					temp[j-1]=temp[j];
					rank[j-1]=rank[j];
					temp[j]=t;
					rank[j]=in;
				}
			}
		}
		return rank;
	}

	public static int checkRank(int in){
		int rank=-1;
		for (int i = 0; i < studentIdArray.length; i++){
			if(studentRank[i]==in){
				rank=i+1;
				break;
			}
		}
		return rank;
	}
	
	public static String rankPlace(int rank){
		String p="";
		int count=0;
		for(int i:studentTot){
			count+=i==-2 ? 1 : 0;
		}
		rank+=rank==(studentIdArray.length-count) ? 100 : 0;
		
		p=rank==1 ? "1 (First)"
		 :rank==2 ? "2 (Second)"
		 :rank==3 ? "3 (Third)"
		 :rank==4 ? "4 (Fourth)"
		 :rank==5 ? "5 (Fifth)"
		 :rank==6 ? "6 (Sixth)"
		 :rank==7 ? "7 (Seventh)"
		 :rank==8 ? "8 (Eighth)"
		 :rank==9 ? "9 (ninth)"
		 :rank==10 ? "10 (tenth)"
		 :rank==11 ? "11 (eleventh)"
		 :rank==12 ? "12 (twelth)"
		 :rank==13 ? "13 (Thirteenth)"
		 :rank==14 ? "14 (Fourteenth)"
		 :rank==15 ? "15 (Fifteenth)"
		 :rank==16 ? "16 (Sixteenth)"
		 :rank==17 ? "17 (Seventeenth)"
		 :rank==18 ? "18 (Eighteenth)"
		 :rank==19 ? "19 (Nineteenth)"
		 :rank==20 ? "20 (Twentieth)"
		 : rank-100+" (Last)";
		 return p;
	}	
	
	public static void printStudentDetails(){
				Scanner input=new Scanner(System.in);
		title("STUDENT DETAILS");
		int i=checkSId();
		if(i==-1){
			clearConsole();
			homePage();
		}
		System.out.println("Student Name     : "+studentNameArray[i]);
		if(prfMarksArray[i]==-1){
			System.out.println("\nMarks yet to be added!\n");
		}else{
			System.out.println("+-----------------------------------+--------------------+");
			String row=String.format("|%-35s|%20d|","Programming Fundamentals Marks",prfMarksArray[i]);
			System.out.println(row);
			row=String.format("|%-35s|%20d|","Database Management System Marks",dbmMarksArray[i]);
			System.out.println(row);
			int tot=dbmMarksArray[i]+prfMarksArray[i];
			row=String.format("|%-35s|%20d|","Total Marks",tot);
			System.out.println(row);
			double avg=tot/2d;
			row=String.format("|%-35s|%20.2f|","Avg. Marks",avg);
			System.out.println(row);
			findTotAvg();
			studentRank=findRank(studentTot);
			row=String.format("|%-35s|%20s|","Rank",rankPlace(checkRank(i)));
			System.out.println(row);
			System.out.println("+-----------------------------------+--------------------+");
		}
		L:while(true){
		System.out.print("Do you want to search another student? (Y/n): ");
		String ans=input.next();
		clearConsole();
		if(ans.equals("y") || ans.equals("Y")){
			printStudentDetails();
		}else if (ans.equals("n") || ans.equals("N")){
		clearConsole();
		homePage();
		}else{
			System.out.println("Wrong Option.Pick Again\n");
			continue L;
		}
		}
		}

	public static void printStudentRanks(){
	Scanner input=new Scanner(System.in);
		title("STUDENT RANKS");
		findTotAvg();
		studentRank=findRank(studentTot);
		System.out.println("+----+----+--------------------+-----------+-----------+");
		String row=String.format("|%-4s|%-4s|%-20s|%11s|%11s|","Rank","ID","Name","Total Marks","Avg. Marks");
		System.out.println(row);
		System.out.println("+----+----+--------------------+-----------+-----------+");
		for(int i:studentRank){
			if(studentTot[i]==-2){
				break;
			}
			row=String.format("|%-4s|%-4s|%-20s|%11d|%11.2f|",checkRank(i),studentIdArray[i],studentNameArray[i],studentTot[i],studentAvg[i]);
			System.out.println(row);
		}
		System.out.println("+----+----+--------------------+-----------+-----------+");
		L:while(true){
		System.out.print("Do you want to go back to main menu?(Y): ");
		String ans=input.next();
		clearConsole();
		if(ans.equals("y") || ans.equals("Y")){
			homePage();
		}else{
				System.out.println("Wrong Option.Pick Again\n");
				continue L;
		}
		}
		}
		
	public static void bestInDbm(int[] a,int[]b){
	Scanner input=new Scanner(System.in);
		String s1="DBM Marks",s2="PRF Marks";
		
		title("BEST IN DATATBASE MANAGEMENT SYSTEM");
		
		System.out.println("+----+--------------------+---------+---------+");
		String row=String.format("|%-4s|%-20s|%9s|%9s|","ID","Name",s1,s2);
		System.out.println(row);
		System.out.println("+----+--------------------+---------+---------+");
		findTotAvg();
		int[] rank=findRank(a);
		for(int i:rank){
			if(studentTot[i]==-2){
				break;
			}
			row=String.format("|%-4s|%-20s|%9d|%9d|",studentIdArray[i],studentNameArray[i],a[i],b[i]);
			System.out.println(row);
		}
		System.out.println("+----+--------------------+---------+---------+");
		L:while(true){
		System.out.print("Do you want to go back to main menu?(Y): ");
		String ans=input.next();
		
		if(ans.equals("y") || ans.equals("Y")){
		clearConsole();
		homePage();
		}else{
			System.out.println("Wrong Option.Pick Again\n");
			continue L;
		}
		}
		}
	public static void bestInPrf(int[] a,int[]b){
	Scanner input=new Scanner(System.in);
		String s1="PRF Marks",s2="DBM Marks";
		
		title("BEST IN PROGRAMMING FUNDAMENTALS");
		
		System.out.println("+----+--------------------+---------+---------+");
		String row=String.format("|%-4s|%-20s|%9s|%9s|","ID","Name",s1,s2);
		System.out.println(row);
		System.out.println("+----+--------------------+---------+---------+");
		findTotAvg();
		int[] rank=findRank(a);
		for(int i:rank){
			if(studentTot[i]==-2){
				break;
			}
			row=String.format("|%-4s|%-20s|%9d|%9d|",studentIdArray[i],studentNameArray[i],a[i],b[i]);
			System.out.println(row);
		}
		System.out.println("+----+--------------------+---------+---------+");
		
		L:while(true){
		System.out.print("Do you want to go back to main menu?(Y): ");
		String ans=input.next();
		
		if(ans.equals("y") || ans.equals("Y")){
			clearConsole();
			homePage();
		}else{
			System.out.println("Wrong Option.Pick Again\n");
			continue L;
		}
		}
		}
	public static void main(String args[]) {
		Scanner input=new Scanner (System.in);
				homePage();	
						
	}
}
