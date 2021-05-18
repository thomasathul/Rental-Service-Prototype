import java.util.*;

class Client{

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        boolean lean=true;
        System.out.println("\n");
        System.out.println("Session active!");

        bikes[] b = new bikes[80];
       
        for (int i = 0; i < b.length; i++) {
          b[i] = new bikes();
        }
        int index=5;
         b[0].addbike(1,"B2231","BMX",600,"Avaliable");
        b[1].addbike(2,"H1335","Hercules",500,"Avaliable");
        b[2].addbike(3,"L3113","Ladybird",600,"Avaliable");
        b[3].addbike(4,"B3351","BMX",650,"Avaliable");
        b[4].addbike(5,"S1321","Hero Sprint",700,"Avaliable");
        
        do{
            System.out.println("----------------------------------");
            System.out.println("What would you like to do?");
            System.out.println("1.Add bikes");
            System.out.println("2.Rent Bikes");
            System.out.println("3.Return Bikes");
            System.out.println("4.Bike List");
            System.out.println("5.Remove bike");
            System.out.println("6.Exit the session");
            System.out.println("----------------------------------");
              int n=sc.nextInt();
            switch(n)
            {
                case 1:{
                    System.out.println("Adding bikes:");
                    
                    System.out.println("Enter number of bikes");
                    int bik=sc.nextInt(); 
                    int arlen=b.length;
                    
                     for(int i=0;i<bik;i++)
                      {
                        int j=index;
                        boolean c=true;
                        System.out.println("Enter Model number");
                        String modelno=sc.next();
                        for(int k=0;k<b.length;k++)
                        {
                        	if(modelno.equals(b[k].model))
                        	{
                        		c=false;
                        	}
                        }
                        if(c)
                        {
                        	System.out.println("Enter Bike name and Price");
                            b[index++].addbike(++j,modelno,sc.next(),sc.nextInt(),"Avaliable");
                        }
                        else
                        {
                        	System.out.println("The bike already exists");
                        }


                      }
                      break;
                    }
                case 2:{
                       System.out.println("Renting:");
             
                        int arlen=b.length;
                        boolean t=false;
                        for(int i=0;i<arlen;i++)
                        {
                        	if(b[i].status=="Avaliable")
                        	{
                                 t=true;
                                 break;
                        	}
                        }
                        if(t){
                        for(int i=0;i<arlen;i++){
                        	if(b[i].name!=null)
                        	{
                            b[i].display();
                            }
                         }
                         System.out.println("Enter the serial number of bike:");
                         int j=sc.nextInt();
                         j--;
                         if(b[j].model!=null)
                         {
                         	if(b[j].status=="Avaliable")
                         	{
                                 b[j].makerent();
                            }
                            else
                            {
                            	System.out.println("The bike is currently unavaliable, Please try again");
                            	continue;
                            }
                         }
                         else
                         {
                         	System.out.println("No bike found");
                         	continue;
                         }
                          System.out.println(b[j].name+" , "+b[j].model + " has been rented");
                       }
                      
                       else
                       {
                             System.out.println("All bikes are on rent");
                       }
                       break;
                       }
                case 3:{
                    System.out.println("Returning:");
                     System.out.println("----------------------------------");
                      System.out.println("Enter the model serial number of bike:");
                      String modelno=sc.next();
                      for(int i=0;i<b.length;i++)
                      {
                          if(modelno.equals(b[i].model))
                          {
                          	if(b[i].status=="On Rent")
                          	{
                            b[i].makereturn();
                            System.out.println(b[i].name+" , "+b[i].model + " has been returned");
                            } 
                            else
                            {
                            	System.out.println("The bike is not on rent, Please try again");                                              
                            	continue;
                            }
                          }
                      }
                      

                      break;

                }   
                case 4: {
                    System.out.println("Displaying Bikes:");
                     int arlen=b.length;
                        for(int i=0;i<arlen;i++){
                        	if(b[i].name!=null)
                        	{
                            b[i].display();
                            }
                             }
                         break;
                } 
                case 5:{
                	System.out.println("----------------------------------");
                	System.out.println("Enter the Model Number to be deleted");
                	String modelno=sc.next();
                	boolean k=false;
                	int c=0;
                	for(int i=0;i<b.length;i++)
                	{
                        if(modelno.equals(b[i].model))
                        {

                        	k=true;
                        	c=i;
                        	break;
                        	
                        }
                        
                	}

                	if(k)
                	{
                		b[c]=new bikes();
                		System.out.println("Removed Successfully!");
                	}
                	else
                	{
                		System.out.println("Bike not found. Please try again");
                	}

                	break;
                } 
                case 6:{
                     System.out.println("----------------------------------");
                    System.out.println("Thank you!");
                    lean=false;
                     break;
                }
                default:
                {
                        System.out.println("Please enter a valid number");
                        continue;
                }
   
                

            }
        
        
        
       
    }while(lean);
    sc.close();
}
}
class bikes{
    public int num;
    public String name;
    public String model;
    public int price;
    public String status;
    bikes(){

    }
    public void addbike(int i,String m,String n,int p,String s) {
          this.num=i;
          this.name=n;
          this.model=m;
          this.price=p;
          this.status=s;
    }
    public void display()
    {
        System.out.println(">"+num+" , "+model+" , "+name+" , "+price+" , "+status);
    }
    public void makerent()
    {
        this.status="On Rent";
    }

    public void makereturn()
    {
       
       this.status="Avaliable";
       
    }

}
