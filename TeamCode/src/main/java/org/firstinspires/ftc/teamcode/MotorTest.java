package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp
public class MotorTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // Declare our motors
        // Make sure your ID's match your configuration
        DcMotor frontIntake = hardwareMap.dcMotor.get("frontIntake");
        DcMotor transferMotor1 = hardwareMap.dcMotor.get("transferMotor1");
        DcMotor transferMotor2 = hardwareMap.dcMotor.get("transferMotor2");
        Servo servo = hardwareMap.servo.get("servo1");
        servo.setPosition(0);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
          frontIntake.setPower(-gamepad1.right_stick_y);
          transferMotor1.setPower(-gamepad1.right_stick_y);
          transferMotor2.setPower(-gamepad1.right_stick_y);
          if (gamepad1.a){
              servo.setPosition(0);
          } else if (gamepad1.y){
              servo.setPosition(1);
            } else if (gamepad1.b){
              servo.setPosition(0.5);
          } else if (gamepad1.x){
              servo.setPosition(0.9);
          } else if (gamepad1.dpad_down){
              frontIntake.setPower(1);
              transferMotor1.setPower(-1);
              servo.setPosition(0);
              sleep(100);
              servo.setPosition(0.1);
              sleep(100);
              servo.setPosition(0.5);
              sleep(100);
              servo.setPosition(0.9);
              sleep(100);
              servo.setPosition(1);
          }
          telemetry.addData("FrontIntake", frontIntake.getPower());
          telemetry.addData("transferMotor1", transferMotor1.getPower());
          telemetry.addData("transferMotor2", transferMotor2.getPower());
          telemetry.addData("rightJoystick", -gamepad1.right_stick_y);
          telemetry.update();

        }
    }
}