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

    public void setPoint(CLFieldPoint point) {
        this.fieldPoint = point;
    }

    private Side oppositeSide;
    private CLFieldPoint fieldPoint;

    public CLFieldPoint getFieldPoint() {
        return fieldPoint;
    }

    public CLFieldPoint getPoint() {
        return fieldPoint;
    }

    private  SuperMiple miple;
    private Infrastructure infrastructure;
    private InfrastructurePart infrastructurePart;
    private boolean connected = false;
    //private ArrayList<Side> connections= new ArrayList<>(Arrays.asList(this));
    private ArrayList<Side> connections= new ArrayList<>();
    public void setConnections(ArrayList<Side> connections) {
        this.connections = connections;
    }

    public void removeMiple(){
        miple = null;
    }

    public void setInfrastructure(Infrastructure infrastructure) {
        this.infrastructure = infrastructure;
    }

    public Infrastructure getInfrastructure() {
        return infrastructure;
    }



    public synchronized void setOppositeSide(Side oppositeSide) {

        this.oppositeSide = oppositeSide;
        oppositeSide.setOnlyOppositeSide(this);

        if(oppositeSide.getInfrastructure()!=null) {

            if (this.getInfrastructure() == null) {
                oppositeSide.getInfrastructure().addOnePart(oppositeSide, this);
                InfrastructurePart part1 = oppositeSide.getInfrastructurePart();
                part1.closeSide(oppositeSide);

                if (part1.isAllSidesConnected()) this.getInfrastructure().getOpenParts().remove(part1);
                System.out.println("close " + oppositeSide);

                this.getInfrastructure().addParts(this);
                if (oppositeSide.getInfrastructure().isFinished()) {
                    oppositeSide.getInfrastructure().finishInfrastructure();
                }
            }
            else {  
                if (this.getInfrastructure()!=oppositeSide.getInfrastructure()) {
                    this.getInfrastructure().connectInfrastructure(this, oppositeSide.getInfrastructure(), oppositeSide);
                }
                else{
                    InfrastructurePart part1 = oppositeSide.getInfrastructurePart();
                    part1.closeSide(oppositeSide);
                    System.out.println("close " + oppositeSide);
                    InfrastructurePart part2 = this.getInfrastructurePart();
                    part2.closeSide(this);
                    System.out.println("close " + this);

                    if (part1.isAllSidesConnected()) this.getInfrastructure().getOpenParts().remove(part1);

                    if (part2.isAllSidesConnected()) this.getInfrastructure().getOpenParts().remove(part2);
                }
                if (this.getInfrastructure().isFinished()) {
                    this.getInfrastructure().finishInfrastructure();
                }
            }
        }else{ if(this.getInfrastructure()!=null) {
            this.getInfrastructure().addOnePart(this, oppositeSide);
            InfrastructurePart part1 = this.getInfrastructurePart();
            part1.closeSide(this);
            System.out.println("close " + this);
            if (part1.isAllSidesConnected()) this.getInfrastructure().getOpenParts().remove(part1);


            this.getInfrastructure().addParts(this);
            if (this.getInfrastructure().isFinished()) {
                this.getInfrastructure().finishInfrastructure();
            }
        }

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

    public void setInfrastructurePart(InfrastructurePart infrastructurePart) {
        this.infrastructurePart = infrastructurePart;
    }

    public InfrastructurePart getInfrastructurePart() {
        return infrastructurePart;
    }

    public Side(final TypeEdge typeEdge, final ArrayList<Side> connections){
        this.typeEdge = typeEdge;
        this.connections.addAll(connections);
    }
    public TypeEdge getTypeEdge(){
        return this.typeEdge;
    }



}
