import React from "react";
import musical_box from "../assets/images/musical_box_2.png";
import PrimaryButton from "~/shared/ui/input/PrimaryButton";
import { useNavigate } from "react-router-dom";

function About() {
    const navigate = useNavigate();

    return (
        <main className="mx-96">
            <div className="flex flex-col justify-center items-center my-12 gap-6">
                <h1 className="h1-hw text-6xl">
                    Making music <span className="gradient-text">tangible</span>
                </h1>
                <div className="flex gap-6 my-6 w-4/5">
                    <div className="flex flex-col gap-2 w-1/2">
                        <p className="text-justify">
                            Lorem ipsum dolor sit amet, consectetur adipiscing
                            elit. Etiam eu turpis molestie, dictum est a, mattis
                            tellus. Sed dignissim, metus nec fringilla accumsan,
                            risus sem sollicitudin lacus, ut interdum tellus
                            elit sed risus. Maecenas eget condimentum velit, sit
                            amet feugiat lectus.
                            <br />
                            <br />
                            Curabitur tempor quis eros tempus lacinia. Nam
                            bibendum pellentesque quam a convallis. Sed ut
                            vulputate nisi. Integer in felis sed leo vestibulum
                            venenatis. Suspendisse quis arcu sem. Aenean feugiat
                            ex eu vestibulum vestibulum. Morbi a eleifend magna.
                            If you have any questions, please
                        </p>
                        <div className="flex justify-end">
                            <PrimaryButton
                                className="px-2"
                                text="Contact us"
                                onClick={() => navigate("/contact-us")}
                            />
                        </div>
                    </div>
                    <img
                        className="w-2/5 object-contain"
                        src={musical_box}
                        alt="Musical box handrawing"
                    />
                </div>
            </div>
        </main>
    );
}

export default About;
