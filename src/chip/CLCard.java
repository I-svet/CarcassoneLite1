package chip;

import java.util.ArrayList;
import java.util.Arrays;

public class CLCard {
    public Side getA() {
        return A;
    }

    public void setA(Side a) {
        A = a;
    }

    public Side getB() {
        return B;
    }

    public void setB(Side b) {
        B = b;
    }

    public Side getC() {
        return C;
    }

    public void setC(Side c) {
        C = c;
    }

    public Side getD() {
        return D;
    }

    public void setD(Side d) {
        D = d;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Side[] getSideM() {
        return SideM;
    }

    public void setSideM(Side[] sideM) {
        SideM = sideM;
    }

    public enum Type
    {
        CityCornerF, ThreeDifCityF,StartGame,City1,City2,City3,City4,City5,City6,CityCornerCHF,Monastery,Road1,Road2,Road3,Road4,Road5,RoadCity1,RoadCity2,RoadCity3,RoadCity4;
        private static final Type[] types = Type.values();
        public static Type getType(int i)
        {
            return Type.types[i];
        }
    }
    private Side A;
    private Side B;
    private Side C;
    private Side D;
    private Center center;
    private Type type;
    private Side[] SideM= new Side[4];


    public CLCard(final Side  A,final Side B, final Side C, final Side D,final Center center,final Type type)
    {
        this.setType(type);
        this.setA(A);
        this.setB(B);
        this.setC(C);
        this.setD(D);
        this.setCenter(center);
        getSideM()[0]=A;
        getSideM()[1]=B;
        getSideM()[2]=C;
        getSideM()[3]=D;

    }
    public Type getType(){
        return this.type;
    }
    public Center getCenter(){
        return this.center;
    }
    public Side getSideA(){
        return this.getA();
    }
    public Side getSideB(){
        return this.getB();
    }
    public Side getSideC(){
        return this.getC();
    }
    public Side getSideD(){
        return this.getD();
    }
    public String toString()
    {
        return getA().getTypeEdge()+" "+ getB().getTypeEdge()+" "+ getC().getTypeEdge()+" " + getC().getTypeEdge()+" "+ getCenter().getCenter()+" "+ getType();
    }
    public CLCard city1(){
        this.setA(new Side(Side.TypeEdge.City, new ArrayList<>(Arrays.asList(getA(), getB(), getD()))));
        this.setB(new Side(Side.TypeEdge.City, new ArrayList<>(Arrays.asList(getA(), getB(), getD()))));
        this.setC(new Side(Side.TypeEdge.field, new ArrayList<>()));
        this.setD(new Side(Side.TypeEdge.City, new ArrayList<>(Arrays.asList(getA(), getB(), getD()))));
        this.setType(Type.City1);
        this.setCenter(null);
        this.getSideM()[0]= this.getA();
        this.getSideM()[1]= this.getB();
        this.getSideM()[2]= this.getC();
        this.getSideM()[3]= this.getD();

        return this;
    }
    public CLCard city2(){
        this.setA(new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(getA(), getD()))));
        this.setB(new Side(Side.TypeEdge.City, new ArrayList<>()));
        this.setC(new Side(Side.TypeEdge.City, new ArrayList<>()));
        this.setD(new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(getA(), getD()))));
        this.setType(Type.City2);
        this.setCenter(null);
        this.getSideM()[0]= this.getA();
        this.getSideM()[1]= this.getB();
        this.getSideM()[2]= this.getC();
        this.getSideM()[3]= this.getD();

        return this;
    }
    public CLCard city3(){
        this.setA(new Side(Side.TypeEdge.field, new ArrayList<>()));
        this.setB(new Side(Side.TypeEdge.City, new ArrayList<>(Arrays.asList(getB(), getC()))));
        this.setC(new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(getB(), getC()))));
        this.setD(new Side(Side.TypeEdge.City, new ArrayList<>()));
        this.setType(Type.City3);
        this.setCenter(null);
        this.getSideM()[0]= this.getA();
        this.getSideM()[1]= this.getB();
        this.getSideM()[2]= this.getC();
        this.getSideM()[3]= this.getD();

        return this;
    }
    public CLCard city4(){
        this.setA(new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(getA(), getD()))));
        this.setB(new Side(Side.TypeEdge.City, new ArrayList<>()));
        this.setC(new Side(Side.TypeEdge.field, new ArrayList<>()));
        this.setD(new Side(Side.TypeEdge.City, new ArrayList<>(Arrays.asList(getA(), getD()))));
        this.setType(Type.City4);
        this.setCenter(null);
        this.getSideM()[0]= this.getA();
        this.getSideM()[1]= this.getB();
        this.getSideM()[2]= this.getC();
        this.getSideM()[3]= this.getD();

        return this;
    }
    public CLCard city5(){
        this.setA(new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(getA(), getB(), getD()))));
        this.setB(new Side(Side.TypeEdge.City, new ArrayList<>()));
        this.setC(new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(getA(), getB(), getD()))));
        this.setD(new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(getA(), getB(), getD()))));
        this.setType(Type.City5);
        this.getSideM()[0]= this.getA();
        this.getSideM()[1]= this.getB();
        this.getSideM()[2]= this.getC();
        this.getSideM()[3]= this.getD();

        this.setCenter(null);
        return this;
    }
    public CLCard CityCornerCHF(){
        this.setA(new Side(Side.TypeEdge.City, new ArrayList<>(Arrays.asList(getA(), getD()))));
        this.setB(new Side(Side.TypeEdge.field, new ArrayList<>()));
        this.setC(new Side(Side.TypeEdge.field, new ArrayList<>()));
        this.setD(new Side(Side.TypeEdge.City, new ArrayList<>(Arrays.asList(getA(), getD()))));
        this.setType(Type.CityCornerCHF);
        this.setCenter(null);
        this.getSideM()[0]= this.getA();
        this.getSideM()[1]= this.getB();
        this.getSideM()[2]= this.getC();
        this.getSideM()[3]= this.getD();

        return this;
    }
    public CLCard Monastery(){
        this.setA(new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(getA(), getC(), getB(), getD()))));
        this.setB(new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(getA(), getC(), getB(), getD()))));
        this.setC(new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(getA(), getC(), getB(), getD()))));
        this.setD(new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(getA(), getC(), getB(), getD()))));
        this.setType(Type.Monastery);
        this.setCenter(new Center(Center.CenterC.monastery));
        this.getSideM()[0]= this.getA();
        this.getSideM()[1]= this.getB();
        this.getSideM()[2]= this.getC();
        this.getSideM()[3]= this.getD();

        return this;
    }
    public CLCard Road1(){
        this.setA(new Side(Side.TypeEdge.road, new ArrayList<>(Arrays.asList(getA(), getC()))));
        this.setB(new Side(Side.TypeEdge.field, new ArrayList<>()));
        this.setC(new Side(Side.TypeEdge.road, new ArrayList<>(Arrays.asList(getA(), getC()))));
        this.setD(new Side(Side.TypeEdge.field, new ArrayList<>()));
        this.setType(Type.Road1);
        this.setCenter(null);
        this.getSideM()[0]= this.getA();
        this.getSideM()[1]= this.getB();
        this.getSideM()[2]= this.getC();
        this.getSideM()[3]= this.getD();

        return this;
    }
    public CLCard Road2(){
        this.setA(new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(getA(), getB()))));
        this.setB(new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(getA(), getB()))));
        this.setC(new Side(Side.TypeEdge.road, new ArrayList<>(Arrays.asList(getC(), getD()))));
        this.setD(new Side(Side.TypeEdge.road, new ArrayList<>(Arrays.asList(getC(), getD()))));
        this.setType(Type.Road2);
        this.setCenter(null);
        this.getSideM()[0]= this.getA();
        this.getSideM()[1]= this.getB();
        this.getSideM()[2]= this.getC();
        this.getSideM()[3]= this.getD();

        return this;
    }
    public CLCard Road3(){
        this.setA(new Side(Side.TypeEdge.field, new ArrayList<>()));
        this.setB(new Side(Side.TypeEdge.road, new ArrayList<>()));
        this.setC(new Side(Side.TypeEdge.road, new ArrayList<>()));
        this.setD(new Side(Side.TypeEdge.road, new ArrayList<>()));
        this.setType(Type.Road3);
        this.setCenter(null);
        this.getSideM()[0]= this.getA();
        this.getSideM()[1]= this.getB();
        this.getSideM()[2]= this.getC();
        this.getSideM()[3]= this.getD();

        return this;
    }
    public CLCard Road4(){
        this.setA(new Side(Side.TypeEdge.road, new ArrayList<>()));
        this.setB(new Side(Side.TypeEdge.road, new ArrayList<>()));
        this.setC(new Side(Side.TypeEdge.road, new ArrayList<>()));
        this.setD(new Side(Side.TypeEdge.road, new ArrayList<>()));
        this.setType(Type.Road4);
        this.setCenter(null);
        this.getSideM()[0]= this.getA();
        this.getSideM()[1]= this.getB();
        this.getSideM()[2]= this.getC();
        this.getSideM()[3]= this.getD();

        return this;
    }
    public CLCard Road5(){
        this.setA(new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(getA(), getB()))));
        this.setB(new Side(Side.TypeEdge.field, new ArrayList<>(Arrays.asList(getA(), getB()))));
        this.setC(new Side(Side.TypeEdge.road, new ArrayList<>(Arrays.asList(getC(), getD()))));
        this.setD(new Side(Side.TypeEdge.road, new ArrayList<>(Arrays.asList(getC(), getD()))));
        this.setType(Type.Road5);
        this.setCenter(null);
        this.getSideM()[0]= this.getA();
        this.getSideM()[1]= this.getB();
        this.getSideM()[2]= this.getC();
        this.getSideM()[3]= this.getD();

        return this;
    }
    public CLCard RoadCity1(){
        this.setA(new Side(Side.TypeEdge.road, new ArrayList<>(Arrays.asList(getA(), getD()))));
        this.setB(new Side(Side.TypeEdge.City, new ArrayList<>()));
        this.setC(new Side(Side.TypeEdge.field, new ArrayList<>()));
        this.setD(new Side(Side.TypeEdge.road, new ArrayList<>(Arrays.asList(getA(), getD()))));
        this.setType(Type.RoadCity1);
        this.setCenter(null);
        this.getSideM()[0]= this.getA();
        this.getSideM()[1]= this.getB();
        this.getSideM()[2]= this.getC();
        this.getSideM()[3]= this.getD();

        return this;
    }
    public CLCard RoadCity2(){
        this.setA(new Side(Side.TypeEdge.road, new ArrayList<>()));
        this.setB(new Side(Side.TypeEdge.City, new ArrayList<>()));
        this.setC(new Side(Side.TypeEdge.road, new ArrayList<>()));
        this.setD(new Side(Side.TypeEdge.road, new ArrayList<>()));
        this.setType(Type.RoadCity2);
        this.setCenter(null);
        this.getSideM()[0]= this.getA();
        this.getSideM()[1]= this.getB();
        this.getSideM()[2]= this.getC();
        this.getSideM()[3]= this.getD();

        return this;
    }
    public CLCard RoadCity3(){
        this.setA(new Side(Side.TypeEdge.City, new ArrayList<>(Arrays.asList(getA(), getB(), getD()))));
        this.setB(new Side(Side.TypeEdge.City, new ArrayList<>(Arrays.asList(getA(), getB(), getD()))));
        this.setC(new Side(Side.TypeEdge.road, new ArrayList<>()));
        this.setD(new Side(Side.TypeEdge.City, new ArrayList<>(Arrays.asList(getA(), getB(), getD()))));
        this.setType(Type.RoadCity3);
        this.setCenter(null);
        this.getSideM()[0]= this.getA();
        this.getSideM()[1]= this.getB();
        this.getSideM()[2]= this.getC();
        this.getSideM()[3]= this.getD();

        return this;
    }
    public CLCard RoadCity4(){
        this.setA(new Side(Side.TypeEdge.City, new ArrayList<>()));
        this.setB(new Side(Side.TypeEdge.road, new ArrayList<>(Arrays.asList(getB(), getC()))));
        this.setC(new Side(Side.TypeEdge.road, new ArrayList<>(Arrays.asList(getB(), getC()))));
        this.setD(new Side(Side.TypeEdge.field, new ArrayList<>()));
        this.setType(Type.RoadCity4);
        this.setCenter(null);
        this.getSideM()[0]= this.getA();
        this.getSideM()[1]= this.getB();
        this.getSideM()[2]= this.getC();
        this.getSideM()[3]= this.getD();

        return this;
    }



    public CLCard(){
        city1();
    }




}
