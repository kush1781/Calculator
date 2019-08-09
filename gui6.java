// kush1781
// Kushal Gupta
// NIT-W
// Calculator made by JAVA-AWT
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class gui6 extends JFrame
{
    private JButton n0,n1,n2,n3,n4,n5,n6,n7,n8,n9;
    private JButton c,b,brac1,brac2,p,s,d,m,div,e,up;
    private JTextField in,o;
    private ButtonGroup grp;
    double ans;
    String st="";

    public gui6()
    {
        super("The CalCi");
        setLayout(new FlowLayout());
        setBackground(Color.BLACK);

        in=new JTextField("input",19); 
        add(in);

        b=new JButton("<--");
        b.setBackground(Color.RED);
        add(b);
        brac1=new JButton("(");
        brac1.setBackground(Color.PINK);
        add(brac1);
        brac2=new JButton(")");
        brac2.setBackground(Color.PINK);
        add(brac2);
        div=new JButton("/");
        div.setBackground(Color.YELLOW);
        add(div);
        n7=new JButton("7");
        n7.setBackground(Color.CYAN);
        add(n7);
        n8=new JButton("8");
        n8.setBackground(Color.CYAN);
        add(n8);
        n9=new JButton("9");
        n9.setBackground(Color.CYAN);
        add(n9);
        m=new JButton("*");
        m.setBackground(Color.YELLOW);
        add(m);
        n4=new JButton("4");
        n4.setBackground(Color.CYAN);
        add(n4);
        n5=new JButton("5");
        n5.setBackground(Color.CYAN);
        add(n5);
        n6=new JButton("6");
        n6.setBackground(Color.CYAN);
        add(n6);
        d=new JButton("-");
        d.setBackground(Color.YELLOW);
        add(d);
        n1=new JButton("1");
        n1.setBackground(Color.CYAN);
        add(n1);
        n2=new JButton("2");
        n2.setBackground(Color.CYAN);
        add(n2);
        n3=new JButton("3");
        n3.setBackground(Color.CYAN);
        add(n3);
        s=new JButton("+");
        s.setBackground(Color.YELLOW);
        add(s);
        c=new JButton("c");
        c.setBackground(Color.RED);
        add(c);
        n0=new JButton("0");
        n0.setBackground(Color.CYAN);
        add(n0);                
        p=new JButton(".");
        p.setBackground(Color.PINK);
        add(p);     
        e=new JButton("=");
        e.setBackground(Color.GREEN);
        add(e); 
        
        up=new JButton("up");
        up.setBackground(Color.ORANGE);
        add(up);
        
        o=new JTextField("output",19); 
        add(o);

        HandlerClass h=new HandlerClass();
        n0.addActionListener(h);
        n1.addActionListener(h);
        n2.addActionListener(h);
        n3.addActionListener(h);
        n4.addActionListener(h);
        n5.addActionListener(h);
        n6.addActionListener(h);
        n7.addActionListener(h);
        n8.addActionListener(h);
        n9.addActionListener(h);
        c.addActionListener(h);
        b.addActionListener(h);
        brac1.addActionListener(h);
        brac2.addActionListener(h);
        p.addActionListener(h);
        s.addActionListener(h);
        d.addActionListener(h);
        m.addActionListener(h);
        div.addActionListener(h);
        up.addActionListener(h);
        e.addActionListener(h);
    } 

    private static String logic(String st1)
    {       
        String ans=In_Post(st1);        
        return ans;
    }

    private static int Pref(char c)
    {
        if(c=='-'||c=='+')
            return 1;
        else if(c=='*'||c=='/')
            return 2;
        return -1;     
    }
   

  /*  private static int Pref(char c)
    {
        if(c=='-')
            return 1;
        else if(c=='+')
            return 2;
        else if(c=='*')
            return 3;
        else if(c=='/')
            return 4;
        return -1;     
    }
    */
    private static String In_Post(String s)
    {
        Stack<Character> st=new Stack<Character>();  
        ArrayList<String> a=new ArrayList<String>();
        int k=1;
        
        String str="";
        String strg="";        
        
        for(int i=0;i<s.length();i++)
        {
            if(!((s.charAt(i)<='9'&&s.charAt(i)>='0')||(s.charAt(i)=='.')))
            {
                if(str!="")
                {
                    a.add(str);
                    str="";
                }
                if(s.charAt(i)=='-')
                {
                    str=str+"-";
                    if(i==0||!((i-1>=0)&&s.charAt(i-1)>='0'&&s.charAt(i-1)<='9'))
                        continue;
                }
                if(s.charAt(i)=='(')
                    st.push('(');
                else if(s.charAt(i)==')')
                {
                    while(!st.empty()&&st.peek()!='(')
                    {
                        if(st.peek()=='-')
                            strg="+";
                        else if(st.peek()=='+')
                            strg="+";
                        else if(st.peek()=='*')
                            strg="*";
                        else if(st.peek()=='/')
                            strg="/";                   
                        a.add(strg);
                        st.pop();
                    }   
                    st.pop();
                }
                else if(!st.empty()&&(Pref(s.charAt(i))<Pref(st.peek())))
                {
                    while(!st.empty()&&st.peek()!='(')
                    {
                        if(st.peek()=='-')
                            strg="+";
                        else if(st.peek()=='+')
                            strg="+";
                        else if(st.peek()=='*')
                            strg="*";
                        else if(st.peek()=='/')
                            strg="/";                   
                        a.add(strg);
                        st.pop();
                    }
                    st.push(s.charAt(i));                       
                }
                else 
                    st.push(s.charAt(i));
                continue;    
            }
            str=str+s.charAt(i);
        }
        if(str!="")
        {
           a.add(str);
           str="";
        }
        while(!st.empty()&&(st.peek()=='+'||st.peek()=='-'||st.peek()=='*'||st.peek()=='/'))
        {
            if(st.peek()=='-')
                strg="+";
            else if(st.peek()=='+')
                strg="+";
            else if(st.peek()=='*')
                strg="*";
            else if(st.peek()=='/')
                strg="/";                   
            a.add(strg);
            st.pop();
        }
        if(!st.empty())
         return "syntax error1";
      
       return Eva_Post(a);    
    }
    
    
    private static String Eva_Post(ArrayList<String>a)
    {
        try 
        {
            String ans;
            Stack<Double> s=new Stack<Double>();
            for(int i=0;i<a.size();i++)
            {
                if(a.get(i)=="+"||a.get(i)=="-"||a.get(i)=="*"||a.get(i)=="/")
                {
                    double an=0,a1,a2;
                    a2=s.peek();
                    s.pop();
                    a1=s.peek();
                    s.pop();
                    if(a.get(i)=="+")
                        an=a1+a2;
                    else if(a.get(i)=="-")
                        an=a1-a2;
                    else if(a.get(i)=="*")
                        an=a1*a2;
                    else if(a.get(i)=="/")
                        an=((a1)*(1.0))/a2;    
                    s.push(an);
                    continue;
                }
                s.push(Double.parseDouble(a.get(i)));
            }
            ans=Double.toString(s.peek());
            return ans;
        }
        catch(Exception e)
        {            
            return "syntax error2";
        }
    }

    private class HandlerClass implements ActionListener
    {
        public void actionPerformed(ActionEvent k)
        {                         
            if(k.getSource() == n0)
                st+="0";
            else if(k.getSource() == n1)
                st+="1";
            else if(k.getSource() == n2)
                st+="2";
            else if(k.getSource() == n3)
                st+="3";
            else if(k.getSource() == n4)
                st+="4";
            else if(k.getSource() == n5)
                st+="5";
            else if(k.getSource() == n6)
                st+="6";
            else if(k.getSource() == n7)
                st+="7";
            else if(k.getSource() == n8)
                st+="8";
            else if(k.getSource() == n9)
                st+="9";
            else if(k.getSource() == b)
            {
                int l=st.length();
                String st1="";
                for(int i=0;i<l-1;i++)
                    st1+=st.charAt(i);
                st=st1;
            }
            else if(k.getSource() == c)
                st="";
            else if(k.getSource() == brac1)
                st+="(";
            else if(k.getSource() == brac2)
                st+=")";
            else if(k.getSource() == p)
                st+=".";
            else if(k.getSource() == s)
                st+="+";
            else if(k.getSource() == d)
                st+="-";
            else if(k.getSource() == m)
                st+="*";
            else if(k.getSource() == div)
                st+="/";
            else if(k.getSource() == e)
            {
                if(st=="")
                 st=in.getText();
                String st1 =st;
                st=logic(st1);
                o.setText(st);
                return;
            }
            else if(k.getSource() == up)
            {
                in.setText(o.getText());
                o.setText("output");
            }
            in.setText(st);
        }
    }
}


