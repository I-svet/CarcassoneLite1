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

     SuperMiple miple = null;
     boolean connected = false;

    public Side(final TypeEdge typeEdge,final ArrayList<Side> connections){
        this.typeEdge = typeEdge;
        this.connections=connections;
    }
    public TypeEdge getTypeEdge(){
        return this.typeEdge;
    }



}
