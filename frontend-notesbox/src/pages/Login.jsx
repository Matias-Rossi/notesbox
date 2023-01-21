import React from 'react'
import Logo from "~/shared/ui/BigLogo";
import Textfield from "~/shared/ui/input/Textfield";
import Checkbox from "~/shared/ui/input/Checkbox";
import PrimaryButton from "~/shared/ui/input/PrimaryButton";
import { Link } from 'react-router-dom';

function Login() {
    return (
        <div className='bg-primary h-full w-full flex flex-col justify-center items-center'>
            <div className="bg-white flex flex-col py-9 px-12 rounded-lg items-center gap-4">
                <div className="w-2/3">
                    <Logo />
                </div>
                <Textfield label="Email" placeholder="Enter your email" type="email" name="email" className="w-64" />
                <Textfield label="Password" placeholder="Enter your password" type="password" name="password" className="w-64" />
                <div className="w-full pl-2">
                    <Checkbox label="Remember me" name="remember" />
                </div>
                <div className="flex flex-col gap-6 w-full">
                    <PrimaryButton text="Sign in" className="w-full" />
                    <OtherOptions />
                </div>
            </div>
            {/* label, placeholder, type, name, id */}
        </div>
    )
}

export default Login

function OtherOptions() {
    return (
        <div className="flex w-full justify-center items-center text-black-75 gap-4">
            <Link to="/signup" className='sans text-sm font-bold hover:underline'>Sign up</Link>
            <Divider />
            <Link to="/forgot" className='sans text-sm hover:underline'>Forgot password?</Link>
        </div>
    );
}

function Divider() {
    return (
        <div
            className="w-5 h-px bg-black-75"
            style={{ transform: "rotate(-90deg)" }}
        />
    );
}