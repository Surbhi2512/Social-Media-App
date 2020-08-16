/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialmedia;

import java.util.ArrayList;
import java.util.Scanner;

public class SocialMedia {

    public static void main(String[] args) {
    
        Scanner scan=new Scanner(System.in);
        int V=5;
        ArrayList<ArrayList<User> > adj= new ArrayList< >();
        
        ArrayList<User> l1=new ArrayList<>();
        ArrayList<User> l2=new ArrayList<>();
        ArrayList<User> l3=new ArrayList<>();
        ArrayList<User> l4=new ArrayList<>();
        ArrayList<User> l5=new ArrayList<>();
        ArrayList<User> l6=new ArrayList<>();
        
        User a[]=new User[5];
        l1.add(new User("Surbhi Mahajan","VNIT",new Duration(1,2017,6,2021),"Singing"));
        a[0]=new User("Surbhi Mahajan","VNIT",new Duration(1,2017,6,2021),"Singing");
        l2.add(new User("Akarsh Raj","VNIT",new Duration(1,2013,6,2017),"Singing"));
        a[1]=new User("Akarsh Raj","VNIT",new Duration(1,2017,6,2021),"Singing");
        l3.add(new User("Yash Charde","VNIT",new Duration(1,2015,6,2019),"Dancing"));
        a[2]=new User("Yash Charde","VNIT",new Duration(1,2017,6,2021),"Dancing");
        l4.add(new User("Dua Lipa","VNIT",new Duration(1,2019,6,2023),"Cricket"));
        a[3]=new User("Dua Lipa","VNIT",new Duration(1,2017,6,2021),"Cricket");
        l5.add(new User("John Doe","VNIT",new Duration(1,2010,6,2014),"Singing"));
        a[4]=new User("John Doe","VNIT",new Duration(1,2017,6,2021),"Singing");
        l6.add(new User("Harry Potter","VNIT",new Duration(1,2010,6,2014),"Singing"));
        
        adj.add(l1);
        adj.add(l2);
        adj.add(l3);
        adj.add(l4);
        adj.add(l5);
        adj.add(l6);
                
                
        Graphs.addEdge(adj, 0, 1);
        Graphs.addEdge(adj, 0, 2);
        Graphs.addEdge(adj, 1, 3);
        Graphs.addEdge(adj, 2, 4);
        Graphs.addEdge(adj, 4, 5);
        
        int c;
        int node;
        int e1,e2;
        int w;
        int n1,n2;
        
        
        while(1==1)
            {
                System.out.println(adj);
                
		System.out.println("1.Sign Up");
		System.out.println("2.Delete account");
		System.out.println("3.Search");
		System.out.println("4.Add Friend");
		System.out.println("5.Unfriend");
                System.out.println("6.Print network");
                System.out.println("7.Find present and past college mates of a person");
                System.out.println("8.Find people with similar hobbies");
                System.out.println("9.Display Connections with degrees");
                System.out.println("10.Display Adjacency List");
                System.out.println("11.Display Adjacency Matrix");
                System.out.println("12.Display path connecting two people");
                System.out.println("Enter your choice");
                c=scan.nextInt();
                
                switch(c){
                    case 1:
                        Scanner sc=new Scanner(System.in);
                        System.out.println("Enter name");
                        String name=sc.nextLine();
                        System.out.println("Enter college");
                        String edu=sc.nextLine();
                        System.out.println("Enter duration");
                        int smonth=sc.nextInt();
                        int syear=sc.nextInt();
                        int emonth=sc.nextInt();
                        int eyear=sc.nextInt();
                        System.out.println("Enter hobby");
                        String hobby=sc.next();
                        Duration dur=new Duration(smonth,syear,emonth,eyear);
                        Graphs.addNode(adj,name,edu,dur,hobby);
                        
                        break;
                    case 2:
                        Scanner sc1=new Scanner(System.in);
                        System.out.println("Enter account name to be deleted");
                        String st=sc1.nextLine();
                        Graphs.search(adj,st);
                        System.out.println("Enter node");
                        node=sc1.nextInt();
                        Graphs.deleteNode(adj,node);
                        break;
                    case 3:
                        Scanner sc2=new Scanner(System.in);
                        String str=sc2.nextLine();
                        Graphs.search(adj, str);
                        break;
                    case 4:
                        Scanner sc3=new Scanner(System.in);
                        
                        System.out.println("Enter 1st person");
                        e1=sc3.nextInt();
                        System.out.println("Enter 2nd personc");
                        e2=sc3.nextInt();
                        Graphs.addEdge(adj,e1 ,e2);
                        break;
                    case 5:
                        Scanner sc4=new Scanner(System.in);
                        System.out.println("Enter 1st person");
                        e1=sc4.nextInt();
                        System.out.println("Enter 2nd person");
                        e2=sc4.nextInt();
                        Graphs.removeEdge(adj,e1 ,e2);
                        break;
                    case 6:
                        System.out.println("Network");
                        Graphs.printNetwork(adj);
                        break;
                    case 7:
                        Scanner sc5=new Scanner(System.in);
                        System.out.println("Enter college");
                        String col=sc5.nextLine();
                        System.out.println("Enter duration");
                        int sm=sc5.nextInt();
                        int sy=sc5.nextInt();
                        int em=sc5.nextInt();
                        int ey=sc5.nextInt();
                        Duration d=new Duration(sm,sy,em,ey);
                        Graphs.Bfs1(adj, col, d);
                        break;
                    case 8:
                        Scanner sc6=new Scanner(System.in);
                        System.out.println("Enter hobby");
                        String hob=sc6.nextLine();
                        Graphs.Bfs2(adj, hob);
                        break;
                    case 9:
                        Scanner sc7=new Scanner(System.in);
                        System.out.println("Enter person");
                        int f=sc7.nextInt();
                        Graphs.degreeBFS(adj,f);
                        break;
                    case 10:
                        Graphs.printlist(adj);
                        break;
                    case 11:
                        Graphs.displaymatrix(adj);
                        break;
                    case 12:
                        Scanner sc8=new Scanner(System.in);
                        System.out.println("Enter person 1");
                        n1=sc8.nextInt();
                        System.out.println("Enter person 2");
                        n2=sc8.nextInt();
                        Graphs.shortestpath(adj, n1, n2);
                        break;
                    default:
                        System.out.println("No valid choice selected"); 
            }

    }
    }
}
    

    
    

