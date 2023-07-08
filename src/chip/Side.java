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
    public enum Connections
    {
        AB,AC,AD,ABC,ABD,ACD,ABCD, BC,BD,BCD,CD,dead_end;
        private static final Connections[] conn = Connections.values();
        public static Connections getConnections(int i)
        {
            return Connections.conn[i];
        }
    }
    public TypeEdge typeEdge;
    public Connections conn;
    public ArrayList<Side> connections;
    public SuperMiple miple =null;

    public Side(final TypeEdge typeEdge,final ArrayList<Side> connections){
        this.typeEdge = typeEdge;
        this.connections=connections;
    }
    public TypeEdge getTypeEdge(){
        return this.typeEdge;
    }
    public Connections getConn(){
        return this.conn;
    }


}
