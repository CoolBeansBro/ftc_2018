
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Aniketh on 11/16/2017.
 */
@Autonomous
public class depotAuto extends LinearOpMode {
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor plow;

    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() throws InterruptedException {
        backRight = hardwareMap.dcMotor.get("back_right");
        backLeft = hardwareMap.dcMotor.get("back_left");
        frontRight = hardwareMap.dcMotor.get("front_right");
        frontLeft = hardwareMap.dcMotor.get("front_left");
        plow = hardwareMap.dcMotor.get("plow");

        waitForStart();

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 3.0)) {
            frontLeft.setPower(0.5);
            backLeft.setPower(0.5);
            frontRight.setPower(-0.5);
            backRight.setPower(-0.5);
        }

        runtime.reset();

        while (opModeIsActive() && (runtime.seconds() < 1.5)) {
            plow.setPower(0.5);
        }

        runtime.reset();

        while (opModeIsActive() && (runtime.seconds() < 2)) {
            frontLeft.setPower(-0.5);
            backLeft.setPower(-0.5);
            frontRight.setPower(0.5);
            backRight.setPower(0.5);
        }


    }
}