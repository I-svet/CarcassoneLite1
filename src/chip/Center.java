package chip;

import chipMiple.SuperMiple;

public class Center {
    enum CenterC
    {
        monastery,empty;
        private static final CenterC[] centers = CenterC.values();
        public static CenterC getCenter(int i)
        {
            return CenterC.centers[i];
        }
    }
    public CenterC center;
    public SuperMiple miple;
    public CLFieldPoint clFieldPoint;

    public SuperMiple getMiple() {
        return miple;
    }
    public void removeMiple() {
         miple=null;
    }

    public CLFieldPoint getClFieldPoint() {
        return clFieldPoint;
    }

    public Center(final CenterC center){
        this.center = center;
    }
    public CenterC getCenter(){
        return this.center;
    }
}
