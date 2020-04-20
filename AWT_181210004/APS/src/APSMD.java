import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class APSMD{
    String Name;
    String DOB;
    String EmailID;
    String PhoneNo;
    String Address;
    String Gender;
    String Nationality;
    String EduQual[];
    String Skills[];
    String WorkExp[];

    Frame frm;
    TextField tf;

    Label lrb; //For Resume Builder
    Label PerInfo; //For Personal Information
    Label EdQua; //For Educational Qualifications
    Label sk; //For Skills
    Label WoE;//For Work Experience

    Label pi[]; //Array labels for personal info
    Label eq[]; //Array labels for educational qualifications
    Label we[];//Array labels for work experiences

    TextField tfpi[]; //Text field for personal info
    TextField tfeq[]; //Text field for educational qualifications
    TextField tfwe[]; //Text field for work experiences
    TextField tfsk[]; //Text field for skills

    Button br; //Reset Button
    Button bg;// Generate Button

    APSMD(){
        frm = new Frame();
        frm.setSize(1080,720);
        frm.setVisible(true);
        frm.setLayout(null);
        frm.setTitle("Resume - CV Builder");
        frm.setBackground(Color.lightGray);
        tf = new TextField("Enter Here");
        lrb = new Label("Resume Builder");
        lrb.setFont(new Font("SanSerif",Font.BOLD,35));
        lrb.setBounds(700,50,400,40);
        frm.add(lrb);


        Personal_Info(); // Initializes labels and fields for Personal Information
        Edu_Qualification(); // Initializes labels and fields for Educational Qualifications
        Work_Experience(); // Initializes labels and fields for Work Experiences
        skills();  // Initializes labels and fields for Skills
        GenerateFile();  // Calls File Generator Method

        frm.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void Personal_Info(){
        PerInfo = new Label("Personal Information");
        PerInfo.setFont(new Font("Helvetica",Font.PLAIN,17));
        PerInfo.setBounds(100,100,300,50);
        frm.add(PerInfo);

        pi = new Label[8];
        pi[0] = new Label("First Name");
        pi[1] = new Label("Last Name");
        pi[2] = new Label("D.O.B (dd/mm/yyyy)");
        pi[3] = new Label("Email ID");
        pi[4] = new Label("Contact Number");
        pi[5] = new Label("Address");
        pi[6] = new Label("Gender");
        pi[7] = new Label("Nationality");

        tfpi = new TextField[8];
        for(int i=0;i<8;i++){
            pi[i].setFont(new Font("Helvetica",Font.PLAIN,16));
            pi[i].setBounds(30,150+i*40,200,40);
            tfpi[i] = new TextField();
            tfpi[i].setBounds(240,150+i*40,200,30);
        }
        for(int i=0;i<8;i++){
            frm.add(pi[i]);
            frm.add(tfpi[i]);
        }
    }

    public void Edu_Qualification()
    {
        EdQua = new Label ("Educational Qualification");
        EdQua.setFont(new Font("Helvetica",Font.PLAIN,16));
        EdQua.setBounds(1000,100,300,40);
        frm.add(EdQua);

        eq= new Label[4];
        eq[0] = new Label ("Qualifications");
        eq[0].setBounds(800,150, 180, 40);
        eq[0].setFont(new Font("Helvetica",Font.PLAIN,14));
        eq[1] = new Label ("Institute");
        eq[1].setBounds(1150,150, 140, 40);
        eq[1].setFont(new Font("Helvetica",Font.PLAIN,14));
        eq[2]= new Label ("Year");
        eq[2].setBounds(1380,150,60, 40);
        eq[2].setFont(new Font("Helvetica",Font.PLAIN,14));
        eq[3]= new Label ("GPA/%");
        eq[3].setBounds(1450,150,80, 40);
        eq[3].setFont(new Font("Helvetica",Font.PLAIN,14));
        frm.add(eq[0]);
        frm.add(eq[1]);
        frm.add(eq[2]);
        frm.add(eq[3]);
        tfeq = new TextField[12];
        int j=0;
        for(int i=0;i<12;i++)
        {
            tfeq[i]=new TextField();
            if((i+1)%4==1)
            {
                tfeq[i].setBounds(650, 190+(j*50),350,30);
            }
            else if((i+1)%4==2)
            {
                tfeq[i].setBounds(1050, 190+(j*50),300,30);

            }
            else if((i+1)%4==3)
            {
                tfeq[i].setBounds(1380,190+(j*50),60,30);
            }
            else if((i+1)%4==0)
            {
                tfeq[i].setBounds(1450,190+(j*50),50,30);
                j++;
            }
        }
        for(int i=0;i<12;i++)
        {
            frm.add(tfeq[i]);
        }
    }

    public void Work_Experience()
    {
        WoE = new Label ("Work Experience");
        WoE.setFont(new Font("Helvetica",Font.PLAIN,16));
        WoE.setBounds(1000,400,300,40);
        frm.add(WoE);
        we= new Label[3];
        we[0] = new Label ("Company");
        we[0].setBounds(800,440, 200, 40);
        we[0].setFont(new Font("Helvetica",Font.PLAIN,14));
        we[1] = new Label ("Job Title");
        we[1].setBounds(1150,440, 150, 40);
        we[1].setFont(new Font("Helvetica",Font.PLAIN,14));
        we[2]= new Label ("Exp(in yrs)");
        we[2].setBounds(1400,440,100, 40);
        we[2].setFont(new Font("Helvetica",Font.PLAIN,14));
        frm.add(we[0]);
        frm.add(we[1]);
        frm.add(we[2]);

        tfwe = new TextField[9];
        int j=0;
        for(int i=0;i<9;i++)
        {
            tfwe[i]=new TextField();
            if((i+1)%3==1)
            {
                tfwe[i].setBounds(650, 480+(j*50),350,30);
            }
            else if((i+1)%3==2)
            {
                tfwe[i].setBounds(1050, 480+(j*50),300,30);

            }
            else if((i+1)%3==0)
            {
                tfwe[i].setBounds(1400,480+(j*50),60,30);
                j++;
            }
        }
        for(int i=0;i<9;i++)
        {
            frm.add(tfwe[i]);
        }
    }

    public void skills()
    {
        sk = new Label ("Skills");
        sk.setFont(new Font("Helvetica",Font.PLAIN,16));
        sk.setBounds(100,480,200,40);
        frm.add(sk);
        tfsk = new TextField[5];
        for(int i=0;i<5;i++)
        {
            tfsk[i]=new TextField();
            tfsk[i].setBounds(50,540+i*50,400,30);
        }
        for(int i=0;i<5;i++)
        {
            frm.add(tfsk[i]);
        }

    }

    public void GenerateFile()    // Method to generate file
    {
        Label temp=new Label();
        temp.setBounds(1000, 780,600, 20);
        temp.setFont(new Font("Calibri",Font.BOLD,12));
        bg = new Button("Generate");
        bg.setBounds(800, 700, 200, 50);
        bg.setBackground(Color.gray);
        bg.setFont(new Font("Helvetica",Font.BOLD,18));
        br = new Button("Reset");
        br.setBounds(1050, 700, 200, 50);
        br.setBackground(Color.gray);
        br.setFont(new Font("Helvetica",Font.BOLD,18));
        frm.add(bg);
        frm.add(br);
        bg.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Boolean c=CheckFields();
                System.out.print(c);//check textFields
                String a= e.getActionCommand();
                if(a=="Generate"&&c)   // if button is pressed
                {
                    bg.setBackground(Color.LIGHT_GRAY);
                    temp.setText("Your Resume file has been generated!");
                    try {
                        writeFile();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                else {
                    temp.setText("Please fill the fields!");
                }
                frm.add(temp);
            }
        });
        br.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String a= e.getActionCommand();
                if(a=="Reset")  // if button is pressed
                {
                    br.setBackground(Color.LIGHT_GRAY);
                    resetFields();
                    temp.setText("");
                    bg.setBackground(Color.LIGHT_GRAY);
                }
            }
        });
    }
    public void writeFile() throws IOException
    {
        Name = tfpi[0].getText();
        Name=Name+" "+tfpi[1].getText();
        DOB = tfpi[2].getText();
        EmailID=tfpi[3].getText();
        PhoneNo=tfpi[4].getText();
        Address=tfpi[5].getText();
        Gender=tfpi[6].getText();
        Nationality=tfpi[7].getText();
        Skills=new String[5];
        EduQual=new String[3];
        WorkExp=new String[3];
        for(int i=0,j=0;j<3;i=i+4,j++)
        {
            EduQual[j]=new String();
            EduQual[j]="Qualification : "+tfeq[i].getText()+" \n Name of Institute : "+tfeq[i+1].getText() +" \n Year Passed : " +tfeq[i+2].getText()+""
                    + " \n GPA/Percentage : "+tfeq[i+3].getText()+"\n";
        }
        for(int i=0,j=0;j<3;i=i+3,j++)
        {
            WorkExp[j]=new String();
            WorkExp[j]="Company : "+tfwe[i].getText()+" \n Job Title : "+tfwe[i+1].getText() +" \n Years Worked : " +tfwe[i+2].getText()+"\n";
        }
        for(int i=0;i<5;i++)
        {
            Skills[i]=new String();
            Skills[i]= tfsk[i].getText()+"\n";
        }
        FileWriter fileWriter = new FileWriter("Resume.txt");  // SET FILE LOCATION HERE
        PrintWriter write = new PrintWriter(fileWriter);
        write.printf("\t \t \t \t***** RESUME *****\n \n \t \t------ Personal Information ------ \n \n Full Name : %s \n Date Of Birth : %s "
                + "\n E-Mail ID : %s \n Contact Number : %s \n Address : %s \n Gender : %s "
                + " \n Nationality : %s ",Name,DOB,EmailID,PhoneNo,Address,Gender,Nationality);
        write.printf("\n_____________________________________________________________________________________________");
        write.printf("\n \t \t------ Educational Qualifications ------ \n \n");
        for(int i =0 ;i<3;i++)
        {
            write.printf(" %d. %s  \n",(i+1),EduQual[i]);
        }
        write.printf("\n_____________________________________________________________________________________________");
        write.printf("\n \t \t------ Work Experience ------ \n \n");
        for(int i =0 ;i<3;i++)
        {
            write.printf(" %d. %s  \n",(i+1),WorkExp[i]);
        }
        write.printf("\n_____________________________________________________________________________________________");
        write.printf("\n \t \t------ Skills ------- ~ \n \n");
        for(int i =0 ;i<5;i++)
        {
            write.printf(" %d. %s  \n",(i+1),Skills[i]);
        }
        write.close();
    }

    public void resetFields()
    {
        for(int i=0;i<5;i++)
        {
            tfpi[i].setText("");
            tfeq[i].setText("");
            tfwe[i].setText("");
            tfsk[i].setText("");
        }
        for(int i=5;i<7;i++)
        {
            tfpi[i].setText("");
            tfwe[i].setText("");
            tfwe[i+2].setText("");
            tfeq[i].setText("");
            tfeq[i+2].setText("");
            tfeq[i+3].setText("");
            tfeq[i+4].setText("");
        }
        tfpi[7].setText("");
        tfeq[11].setText("");
    }
    public Boolean CheckFields()
    {
        Boolean var=true;
        for(int i=0;i<8;i++)
        {
            if(tfpi[i].getText().isEmpty())
            {
                var=false;
            }
            else
                var=true;
        }
        return var;
    }
    public static void main (String args[]) throws IOException
    {
        APSMD o =new APSMD();
    }

}