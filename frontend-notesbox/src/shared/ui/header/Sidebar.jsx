import React from "react";
import { FaTimes, FaSignInAlt } from "react-icons/fa";
import PrimaryButton from "~/shared/ui/input/PrimaryButton";
import { Link } from "react-router-dom";
import Logo from "~/shared/ui/BigLogo";


//import styled from "styled-components";

function Sidebar({ isOpen, toggle }) {
    return (
        <div
            className={`fixed w-full h-full bg-white flex justify-center items-start left-0 ease-in-out duration-300 ${isOpen ? "opacity-100" : "opacity-0"
                } ${isOpen ? "top-0" : "-top-full"}`}
            style={{ zIndex: 999 }}
        >

            {/* SidebarContainer */}
            <FaTimes className="text-black absolute top-5 right-6 bg-transparent text-3xl cursor-pointer outline-none" onClick={toggle} />
            <div
                className="text-black text-center flex flex-col justify-items-start mt-40" /* style={{display: "grid", grid_template_columns: "1fr", grid_template_rows: "repeat(3,80px)", zIndex:999}} */
            >

                {/* SidebarWrapper */}
                <div className="w-full flex justify-center" >
                    <Logo />
                </div>
                {/* NAVEGACION */}
                <SidebarButton toggle={toggle} to="/">Home</SidebarButton>
                <SidebarButton toggle={toggle} to="/catalog">Full catalog</SidebarButton>
                <SidebarButton toggle={toggle} to="/about">About us</SidebarButton>
                <SidebarButton toggle={toggle} to="/contact-us">Contact</SidebarButton>
                <SidebarButton toggle={toggle} to="/terms-and-conditions">Terms & Conditions</SidebarButton>
                <div className="my-5">

                    <PrimaryButton
                        className="px-2"
                        text="Log in"
                        trailingIcon={<FaSignInAlt/>}
                        onClick={() => navigate("/login")}
                    />
                </div>
                {/* TODO  Log in / out */}
            </div>
        </div>
    );
}

function SidebarButton({ to, children, toggle, ...props }) {
    return (
        <Link
            to={to}
            className="text-black sans text-xl flex items-center justify-center ease-in-out duration-200 cursor-pointer hover:ease-in-out hover:duration-200 hover:text-green-500 mt-5"
            onClick={toggle}
        >
            {children}
        </Link>
    );
}

export default Sidebar;