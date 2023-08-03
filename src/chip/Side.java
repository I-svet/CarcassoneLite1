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

    public TypeEdge typeEdge;

    public ArrayList<Side> connections;
    public SuperMiple miple = null;
    public boolean open = true;

    public Side(final TypeEdge typeEdge,final ArrayList<Side> connections){
        this.typeEdge = typeEdge;
        this.connections=connections;
    }
    public TypeEdge getTypeEdge(){
        return this.typeEdge;
    }



}
