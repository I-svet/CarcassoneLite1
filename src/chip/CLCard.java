package chip;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CLCard {
    public enum Type
    {
        CityCornerF, ThreeDifCityF,StartGame,City1,City2,City3,City4,City5,City6,CityCornerCHF,Monastery,Road1,Road2,Road3,Road4,Road5,RoadCity1,RoadCity2,RoadCity3,RoadCity4;
        private static final Type[] types = Type.values();
        public static Type getType(int i)
        {
            return Type.types[i];
        }
    }
    public Side A;
    public Side B;
    public Side C;
    public Side D;
    public Center center;
    public Type type;
    public Side[] SideM= new Side[4];


    public CLCard(final Side  A,final Side B, final Side C, final Side D,final Center center,final Type type)
    {
        this.type=type;
        this.A=A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.center = center;
        SideM[0]=A;
        SideM[1]=B;
        SideM[2]=C;
        SideM[3]=D;

    }
    public Type getType(){
        return this.type;
    }
    public Center getCenter(){
        return this.center;
    }
    public Side getSideA(){
        return this.A;
    }
    public Side getSideB(){
        return this.B;
    }
    public Side getSideC(){
        return this.C;
    }
    public Side getSideD(){
        return this.D;
    }
    public String toString()
    {
        return A.getTypeEdge()+" "+B.getTypeEdge()+" "+C.getTypeEdge()+" " +C.getTypeEdge()+" "+center.getCenter()+" "+type;
    }
    public CLCard city1(){
        this.A=new Side(Side.TypeEdge.City, new ArrayList<>(Arrays.asList(A,B,D)));
        this.B=new Side(Side.TypeEdge.City, new ArrayList<>(Arrays.asList(A,B,D)));
        this.C = new Side(Side.TypeEdge.field, new ArrayList<>());
        this.D = new Side(Side.TypeEdge.City, new ArrayList<>(Arrays.asList(A,B,D)));
        this.type =Type.City1;
        this.center=null;
        this.SideM[0]=this.A;
        this.SideM[1]=this.B;
        this.SideM[2]=this.C;
        this.SideM[3]=this.D;

        return this;
    }
    public CLCard city2(){
        this.A=new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(A,D)));
        this.B=new Side(Side.TypeEdge.City, new ArrayList<>());
        this.C = new Side(Side.TypeEdge.City, new ArrayList<>());
        this.D = new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(A,D)));
        this.type =Type.City2;
        this.center=null;
        this.SideM[0]=this.A;
        this.SideM[1]=this.B;
        this.SideM[2]=this.C;
        this.SideM[3]=this.D;

        return this;
    }
    public CLCard city3(){
        this.A=new Side(Side.TypeEdge.field, new ArrayList<>());
        this.B=new Side(Side.TypeEdge.City, new ArrayList<>(Arrays.asList(B,C)));
        this.C = new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(B,C)));
        this.D = new Side(Side.TypeEdge.City, new ArrayList<>());
        this.type =Type.City3;
        this.center=null;
        this.SideM[0]=this.A;
        this.SideM[1]=this.B;
        this.SideM[2]=this.C;
        this.SideM[3]=this.D;

        return this;
    }
    public CLCard city4(){
        this.A=new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(A,D)));
        this.B=new Side(Side.TypeEdge.City, new ArrayList<>());
        this.C = new Side(Side.TypeEdge.field, new ArrayList<>());
        this.D = new Side(Side.TypeEdge.City, new ArrayList<>(Arrays.asList(A,D)));
        this.type =Type.City4;
        this.center=null;
        this.SideM[0]=this.A;
        this.SideM[1]=this.B;
        this.SideM[2]=this.C;
        this.SideM[3]=this.D;

        return this;
    }
    public CLCard city5(){
        this.A=new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(A,B,D)));
        this.B=new Side(Side.TypeEdge.City, new ArrayList<>());
        this.C = new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(A,B,D)));
        this.D = new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(A,B,D)));
        this.type =Type.City5;
        this.SideM[0]=this.A;
        this.SideM[1]=this.B;
        this.SideM[2]=this.C;
        this.SideM[3]=this.D;

        this.center=null;
        return this;
    }
    public CLCard CityCornerCHF(){
        this.A=new Side(Side.TypeEdge.City, new ArrayList<>(Arrays.asList(A,D)));
        this.B=new Side(Side.TypeEdge.field, new ArrayList<>());
        this.C = new Side(Side.TypeEdge.field, new ArrayList<>());
        this.D = new Side(Side.TypeEdge.City, new ArrayList<>(Arrays.asList(A,D)));
        this.type =Type.CityCornerCHF;
        this.center=null;
        this.SideM[0]=this.A;
        this.SideM[1]=this.B;
        this.SideM[2]=this.C;
        this.SideM[3]=this.D;

        return this;
    }
    public CLCard Monastery(){
        this.A=new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(A,C,B,D)));
        this.B=new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(A,C,B,D)));
        this.C = new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(A,C,B,D)));
        this.D = new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(A,C,B,D)));
        this.type =Type.Monastery;
        this.center= new Center(Center.CenterC.monastery);
        this.SideM[0]=this.A;
        this.SideM[1]=this.B;
        this.SideM[2]=this.C;
        this.SideM[3]=this.D;

        return this;
    }
    public CLCard Road1(){
        this.A=new Side(Side.TypeEdge.road, new ArrayList<>(Arrays.asList(A,C)));
        this.B=new Side(Side.TypeEdge.field, new ArrayList<>());
        this.C = new Side(Side.TypeEdge.road, new ArrayList<>(Arrays.asList(A,C)));
        this.D = new Side(Side.TypeEdge.field, new ArrayList<>());
        this.type =Type.Road1;
        this.center=null;
        this.SideM[0]=this.A;
        this.SideM[1]=this.B;
        this.SideM[2]=this.C;
        this.SideM[3]=this.D;

        return this;
    }
    public CLCard Road2(){
        this.A=new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(A,B)));
        this.B=new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(A,B)));
        this.C = new Side(Side.TypeEdge.road, new ArrayList<>(Arrays.asList(C,D)));
        this.D = new Side(Side.TypeEdge.road, new ArrayList<>(Arrays.asList(C,D)));
        this.type =Type.Road2;
        this.center=null;
        this.SideM[0]=this.A;
        this.SideM[1]=this.B;
        this.SideM[2]=this.C;
        this.SideM[3]=this.D;

        return this;
    }
    public CLCard Road3(){
        this.A=new Side(Side.TypeEdge.field, new ArrayList<>());
        this.B=new Side(Side.TypeEdge.road, new ArrayList<>());
        this.C = new Side(Side.TypeEdge.road, new ArrayList<>());
        this.D = new Side(Side.TypeEdge.road, new ArrayList<>());
        this.type =Type.Road3;
        this.center=null;
        this.SideM[0]=this.A;
        this.SideM[1]=this.B;
        this.SideM[2]=this.C;
        this.SideM[3]=this.D;

        return this;
    }
    public CLCard Road4(){
        this.A=new Side(Side.TypeEdge.road, new ArrayList<>());
        this.B=new Side(Side.TypeEdge.road, new ArrayList<>());
        this.C = new Side(Side.TypeEdge.road, new ArrayList<>());
        this.D = new Side(Side.TypeEdge.road, new ArrayList<>());
        this.type =Type.Road4;
        this.center=null;
        this.SideM[0]=this.A;
        this.SideM[1]=this.B;
        this.SideM[2]=this.C;
        this.SideM[3]=this.D;

        return this;
    }
    public CLCard Road5(){
        this.A=new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(A,B)));
        this.B=new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(A,B)));
        this.C = new Side(Side.TypeEdge.road, new ArrayList<>(Arrays.asList(C,D)));
        this.D = new Side(Side.TypeEdge.road, new ArrayList<>(Arrays.asList(C,D)));
        this.type =Type.Road5;
        this.center=null;
        this.SideM[0]=this.A;
        this.SideM[1]=this.B;
        this.SideM[2]=this.C;
        this.SideM[3]=this.D;

        return this;
    }
    public CLCard RoadCity1(){
        this.A=new Side(Side.TypeEdge.road, new ArrayList<>(Arrays.asList(A,D)));
        this.B=new Side(Side.TypeEdge.City, new ArrayList<>());
        this.C = new Side(Side.TypeEdge.field, new ArrayList<>());
        this.D = new Side(Side.TypeEdge.road, new ArrayList<>(Arrays.asList(A,D)));
        this.type =Type.RoadCity1;
        this.center=null;
        this.SideM[0]=this.A;
        this.SideM[1]=this.B;
        this.SideM[2]=this.C;
        this.SideM[3]=this.D;

        return this;
    }
    public CLCard RoadCity2(){
        this.A=new Side(Side.TypeEdge.road, new ArrayList<>());
        this.B=new Side(Side.TypeEdge.City, new ArrayList<>());
        this.C = new Side(Side.TypeEdge.road, new ArrayList<>());
        this.D = new Side(Side.TypeEdge.road, new ArrayList<>());
        this.type =Type.RoadCity2;
        this.center=null;
        this.SideM[0]=this.A;
        this.SideM[1]=this.B;
        this.SideM[2]=this.C;
        this.SideM[3]=this.D;

        return this;
    }
    public CLCard RoadCity3(){
        this.A=new Side(Side.TypeEdge.City, new ArrayList<>(Arrays.asList(A,B,D)));
        this.B=new Side(Side.TypeEdge.City, new ArrayList<>(Arrays.asList(A,B,D)));
        this.C = new Side(Side.TypeEdge.road, new ArrayList<>());
        this.D = new Side(Side.TypeEdge.City, new ArrayList<>(Arrays.asList(A,B,D)));
        this.type =Type.RoadCity3;
        this.center=null;
        this.SideM[0]=this.A;
        this.SideM[1]=this.B;
        this.SideM[2]=this.C;
        this.SideM[3]=this.D;

        return this;
    }
    public CLCard RoadCity4(){
        this.A=new Side(Side.TypeEdge.City, new ArrayList<>());
        this.B=new Side(Side.TypeEdge.road, new ArrayList<>(Arrays.asList(B,C)));
        this.C = new Side(Side.TypeEdge.road, new ArrayList<>(Arrays.asList(B,C)));
        this.D = new Side(Side.TypeEdge.field, new ArrayList<>());
        this.type =Type.RoadCity4;
        this.center=null;
        this.SideM[0]=this.A;
        this.SideM[1]=this.B;
        this.SideM[2]=this.C;
        this.SideM[3]=this.D;

        return this;
    }



    public CLCard(){
        city1();
    }




}
