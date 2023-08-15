package chip;

import chipMiple.SuperMiple;

import java.util.ArrayList;

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


    private ArrayList<Side> connections;

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

    private  SuperMiple miple = null;
     private boolean connected = false;
     public void connect(){connected=true;}

    public Side(final TypeEdge typeEdge,final ArrayList<Side> connections){
        this.typeEdge = typeEdge;
        this.connections=connections;
    }
    public TypeEdge getTypeEdge(){
        return this.typeEdge;
    }



}
