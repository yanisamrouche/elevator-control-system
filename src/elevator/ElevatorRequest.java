package elevator;

import java.util.Comparator;

/**
 * This class will be the encapsulation for the InsideElevatorRequest & OutsideElevatorRequest
 *
 */
public class ElevatorRequest implements Comparable<ElevatorRequest> {

    private InsideElevatorRequest insideElevatorRequest;
    private OutsideElevatorRequest outsideElevatorRequest;

    public ElevatorRequest(InsideElevatorRequest insideElevatorRequest, OutsideElevatorRequest outsideElevatorRequest){
        this.insideElevatorRequest = insideElevatorRequest;
        this.outsideElevatorRequest = outsideElevatorRequest;
    }

    public InsideElevatorRequest getInsideElevatorRequest() {
        return insideElevatorRequest;
    }

    public void setInsideElevatorRequest(InsideElevatorRequest insideElevatorRequest) {
        this.insideElevatorRequest = insideElevatorRequest;
    }

    public OutsideElevatorRequest getOutsideElevatorRequest() {
        return outsideElevatorRequest;
    }

    public void setOutsideElevatorRequest(OutsideElevatorRequest outsideElevatorRequest) {
        this.outsideElevatorRequest = outsideElevatorRequest;
    }


    @Override
    public int compareTo(ElevatorRequest o) {
        if(this.getInsideElevatorRequest().getDstFloor() == o.getInsideElevatorRequest().getDstFloor())
            return 0;
        else if(this.getInsideElevatorRequest().getDstFloor() > o.getInsideElevatorRequest().getDstFloor())
            return 1;
        else
            return -1;
    }
}
