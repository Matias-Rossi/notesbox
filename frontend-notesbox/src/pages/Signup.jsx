import React from 'react';
import Textfield from "~/shared/ui/input/Textfield";
import Checkbox from "~/shared/ui/input/Checkbox";
import PrimaryButton from "~/shared/ui/input/PrimaryButton";
import { Link } from 'react-router-dom';

function Signup() {
    /* Add validations */
    const signup = async () => {
        // User data
        const password = document.getElementById('password').value;
        const repeatPassword = document.getElementById('repeatPassword').value;
        if (password !== repeatPassword) {
            alert("Passwords do not match.");
            return;
        }
        const email = document.getElementById('email').value;
        const fullName = document.getElementById('name').value;

        // Address
        const street = document.getElementById('street').value;
        const streetNumber = document.getElementById('streetNumber').value;
        const city = document.getElementById('city').value;
        const state = document.getElementById('state').value;
        const country = document.getElementById('country').value;
        const floor = document.getElementById('floor').value;
        const apartment = document.getElementById('apartment').value;

        /* TODO: Create wrapper in front and backend */

        const user = {
            email: email,
            hashedPassword: password //Which isn't hashed
        };

        const request = await fetch("api/signup", {
            method: "POST",
            headers: {
                'Accept': "application/json",
                "Content-Type": "application/json",
            },
            body: JSON.stringify(user)
        });

        const response = await request.text();
        if (response != 'FAIL') {
            localStorage.token = response;
            localStorage.email = usuario.email;
            window.location.href = '';
        } else {
            alert("Las credenciales no son válidas.");
        }
    }

    return (
        <div className='bg-primary h-full w-full flex flex-col justify-center items-center'>
            <form className="bg-white flex flex-col py-9 px-12 rounded-lg items-center gap-4">
                <h2 className='cursive font-normal'> Ready to <span className="gradient-text">discover something new?</span></h2>
                <div className="grid grid-cols-2 gap-x-6 gap-y-3 w-fit">
                    <Textfield label="Email*" placeholder="Enter your email" type="email" name="email" className="w-64" width="w-64" />
                    <Textfield label="Name*" placeholder="Enter your full name" type="text" name="name" className="w-64" width="w-64" />
                    <Textfield label="Password*" placeholder="Enter your password" type="password" name="password" width="w-64" />
                    <Textfield label="Confirm password*" placeholder="Repeat your password" type="password" name="repeatPassword" className="w-64" width="w-64" />
                    <div className="w-full col-span-2">

                        <Divider />
                    </div>
                </div>
                <div className="flex justify-between items-end w-full">
                    <h3>Address info</h3>
                    <p className='text-black-50'>(Not mandatory nor verified in this demo)</p>
                </div>
                <div className="grid grid-cols-2 gap-x-6 gap-y-3 w-fit">
                    <Textfield label="Street address*" placeholder="e.g. Baker street" type="text" name="street" width="w-64" />
                    <Textfield label="Street number*" placeholder="e.g. 221" type="text" name="streetNumber" width="w-64" />
                    <Textfield label="City*" placeholder="e.g. London" type="text" name="city" width="w-64" />
                    <Textfield label="Province/State*" placeholder="e.g. 221" type="text" name="state" width="w-64" />
                    <Textfield label="Country*" placeholder="e.g. United Kingdom" type="text" name="country" width="w-64" />
                    <div className='flex justify-between w-64'>
                        <Textfield label="Floor" placeholder="e.g. 3" type="text" name="floor" className="w-24" width="w-1/2" />
                        <Textfield label="Apartment" placeholder="e.g. C" type="text" name="apartment" className="w-36" width="1/2" />
                    </div>
                    <div className="flex col-span-2 justify-between">
                        <div className="flex flex-col">
                            <div className="w-full pl-2">
                                <div className="flex justify-start items-center">
                                    <Checkbox label="I accept the&nbsp;" name="acceptTermsConditions" />
                                    <Link to="/terms-and-conditions" target="_blank" rel="noopener noreferrer"
                                        className='sans underline break-normal'
                                    >Terms & Conditions</Link>
                                </div>
                                <Checkbox label="Get offers and news via email" name="getNotified" />
                            </div>
                        </div>
                        <div className="flex justify-end h-5/6 gap-6 w-48">
                            <PrimaryButton text="Sign up" className="w-5/6" />
                        </div>
                    </div>
                    <div className="w-full flex justify-center col-span-2 -mb-4">
                        <Link to="/login" className='sans text-black-50 text-center'>Already have an account?</Link>
                    </div>
                </div>

            </form>
            {/* label, placeholder, type, name, id */}
        </div>
    )
}

export default Signup

function Divider() {
    return (
        <div className="w-full h-px bg-black-75" />
    );
}