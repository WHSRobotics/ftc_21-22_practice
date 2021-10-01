package org.whitneyrobotics.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveTrain {

    private DcMotor topLeft;
    private DcMotor bottomLeft;
    private DcMotor topRight;
    private DcMotor bottomRight;


    public DriveTrain(HardwareMap map) {

        topLeft = map.dcMotor.get("topLeft");
        bottomLeft = map.dcMotor.get("bottomLeft");
        topRight = map.dcMotor.get("topRight");
        bottomRight = map.dcMotor.get("bottomRight");

        topLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        bottomLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void operate(double rightStickY, double leftStickY, boolean toggleReverse) {
        int reverse = toggleReverse ? -1 : 1;

        topLeft.setPower(leftStickY*reverse);
        bottomLeft.setPower(leftStickY*reverse);

        topRight.setPower(rightStickY*reverse);
        bottomRight.setPower(rightStickY*reverse);
    }

    public double[] getEncoderPositions() {
        double[] positions = new double[2];

        positions[0] = (topLeft.getCurrentPosition() + bottomLeft.getCurrentPosition()) / 2;
        positions[1] = (topRight.getCurrentPosition() + bottomRight.getCurrentPosition()) / 2;

        return positions;
    }

}
