import React from 'react'
import Logo from "~/shared/ui/BigLogo";
import Textfield from "~/shared/ui/input/Textfield";
import Checkbox from "~/shared/ui/input/Checkbox";
import PrimaryButton from "~/shared/ui/input/PrimaryButton";
import {Buffer} from 'buffer';
import { config } from "~/shared/data/config";
import { Link } from 'react-router-dom';

function Login() {
    const login = async event => {
        event.preventDefault();
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;
        const user = {
            email: email,
            password: password
        };

        const request = await fetch(config.backend_url + "/api/auth/login", {
            method: "POST",
            headers: {
                'Accept': "application/json",
                "Content-Type": "application/json",
                //"Authorization": "Basic " + Buffer.from(`${email}:${password}`, 'base64')
            },
            body: JSON.stringify(user)
        });

        const response = await request.text();
        console.log(response);
        if (response != 'FAIL') {
            console.log("Valido");
            localStorage.token = response;
            localStorage.email = user.email;
            window.location.href = '/';
        } else {
            console.log("Invalido");
            alert("Las credenciales no son válidas.");
        }
    }

    return (
        <div className='bg-primary w-full flex flex-col justify-center items-center h-screen'>
            <form className="bg-white flex flex-col py-9 px-12 rounded-lg items-center gap-4 sm:px-6 sm:py-4" onSubmit={login}>
                <div className="w-2/3">
                    <Logo />
                </div>
                <Textfield label="Email" placeholder="Enter your email" type="email" name="email" className="w-64" />
                <Textfield label="Password" placeholder="Enter your password" type="password" name="password" className="w-64" />
                <div className="w-full pl-2">
                    <Checkbox label="Remember me" name="remember" />
                </div>
                <div className="flex flex-col gap-6 w-full">
                    <PrimaryButton text="Sign in" className="w-full"/>
                    <OtherOptions />
                </div>
            </form>
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