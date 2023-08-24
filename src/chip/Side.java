package chip;

import City.*;
import chipMiple.SuperMiple;

import java.util.ArrayList;
import java.util.Arrays;

public class Side {
    public enum TypeEdge
    {
        City, field,road;
        private static final TypeEdge[] edges = TypeEdge.values();
        public static TypeEdge getTypeEdge(int i)
        {
            return TypeEdge.edges[i];
        }
    }

    private TypeEdge typeEdge;
    private Side oppositeSide;
    private  SuperMiple miple;
    private boolean connected = false;
    //private ArrayList<Side> connections= new ArrayList<>(Arrays.asList(this));
    private ArrayList<Side> connections= new ArrayList<>();
    public void setConnections(ArrayList<Side> connections) {
        this.connections = connections;
    }

    // private ArrayList<Side> connections= new ArrayList<>();
    private City city;
    private CityPart cityPart;

    public void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }



    public void setOppositeSide(Side oppositeSide) {

        this.oppositeSide = oppositeSide;
      //  oppositeSide.setOnlyOppositeSide(this);

        if(oppositeSide.getCity()!=null && this.getCity() ==null)
        {
            oppositeSide.getCity().addOnePart(oppositeSide,this);
            oppositeSide.getCity().addParts(this);
        }
    }
    public void setOnlyOppositeSide(Side oppositeSide) {

        this.oppositeSide = oppositeSide;

    }

    public Side getOppositeSide() {
        return oppositeSide;
    }



    public ArrayList<Side> getConnections() {
        return connections;
    }

    public SuperMiple getMiple() {
        return miple;
    }

    public boolean isConnected() {
        return connected;
    }


    public void setMiple(SuperMiple miple) {
        this.miple = miple;
    }


     public void connect(){connected=true;}

    public void setCityPart(CityPart cityPart) {
        this.cityPart = cityPart;
    }

    public CityPart getCityPart() {
        return cityPart;
    }

    public Side(final TypeEdge typeEdge, final ArrayList<Side> connections){
        this.typeEdge = typeEdge;
        this.connections.addAll(connections);
    }
    public TypeEdge getTypeEdge(){
        return this.typeEdge;
    }



}
