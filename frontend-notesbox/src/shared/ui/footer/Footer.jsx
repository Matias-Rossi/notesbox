import React from "react";
import FooterLogo from "~/shared/ui/footer/FooterLogo";
import { FaInstagram, FaMapPin } from "react-icons/fa";
import { NavLink } from "react-router-dom";

function Footer() {
  const footerStyle = {
    backgroundColor: "#E0E0E0",
    padding: "2rem 0 "
  };

  return (
    <footer>
      <div className="" style={footerStyle}>
        <div className="flex justify-center gap-5 pb-3">
          <FooterInfo />
          <Divider />
          <FooterSiteMap />
        </div>
      </div>
      {/* Copyright notice */}
      <div className="w-full bg-black-25 flex justify-center gap-2 py-2">
        <p className="text-black">Copyright © 2022 Notesbox. All rights reserved</p>
        <Divider />
        <a href="https://github.com/Matias-Rossi/notesbox" className="sans text-black font-bold hover:underline">About this website</a> {/* TODO Add hyperlink to repository readme */}
      </div>
    </footer>
  );
}

export default Footer;

function FooterInfo() {
  return (
    <div className="flex flex-col justify-center gap-4">
      <div className="flex flex-col justify-center items-center">
        <FooterLogo />
        <p className="text-black">Making music tangible</p>
      </div>
      <div className="flex flex-col justify-center gap-2 items-start">
        <div className="flex items-center gap-2">
          <FaInstagram />
          <p className="text-black">notesbox</p>
        </div>
        <div className="flex items-center gap-2">
          <FaMapPin />
          <p className="text-black">24th Vernet y Sáez St. C3214, Newport</p>
        </div>
      </div>
    </div>
  );
}

function FooterSiteMap() {
  const scrollToTop = () => {
    window.scrollTo({top: 0, behavior: 'smooth'});
  }
  
  return(  
    <div className="flex flex-col gap-2">
      <FooterNavLink to="/" text="Home">Home</FooterNavLink>
      <FooterNavLink to="/catalog" text="Full catalog"/>
      <FooterNavLink to="/about" text="About us"/>
      <FooterNavLink to="/contact" text="Contact"/>
      <FooterNavLink to="/profile" text="Profile"/>
      <FooterNavLink to="/terms-and-conditions" text="Terms & Conditions"/>
      <a className='text-black sans hover:underline hover:cursor-pointer' onClick={scrollToTop}>Go back to top</a>
    </div>
  );
}

function FooterNavLink({to, text}) {
  const activeStyle = {
    fontWeight: "bold",
  }

  return(
    <NavLink className="sans text-black hover:underline" style={({isActive}) => isActive ? activeStyle : undefined} to={to}>
      {text}
    </NavLink>
  )
}

function Divider() {
  return (
    <div className="w-px self-stretch" style={{ backgroundColor: "#5A5A5A" }} />
  );
}
