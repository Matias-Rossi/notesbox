import React from "react";
import FooterLogo from "~/shared/ui/footer/FooterLogo";
import { FaInstagram, FaMapPin } from "react-icons/fa";
import { NavLink } from "react-router-dom";
import { useMediaQuery } from "react-responsive";
import { useLocation } from "react-router-dom";

function Footer() {
  const isMobile = useMediaQuery({ query: "(max-width: 639px)" });
  const shouldHide = useLocation().pathname === "/login";


  const footerStyle = {
    backgroundColor: "#E0E0E0",
  };

  return (
    <footer className={`${shouldHide? "hidden" : ""}`}>
      <div style={footerStyle}>
        <div className="flex justify-center gap-5 py-8 sm:py-4 sm:px-8">
          <FooterInfo />
          <Divider className="sm:hidden" />
          <FooterSiteMap className="sm:hidden" />
        </div>
      </div>
      {/* Copyright notice */}
      <div className="w-full bg-black-25 flex justify-center gap-2 py-2 sm:flex-col sm:text-center">
        <p className="text-black">Copyright © 2022 Notesbox. All rights reserved</p>
        <Divider className="sm:hidden" />
        
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

function FooterSiteMap({className}) {
  const scrollToTop = () => {
    window.scrollTo({top: 0, behavior: 'smooth'});
  }
  
  return(  
    <div className={"flex flex-col gap-2 " + className}>
      <FooterNavLink to="/" text="Home">Home</FooterNavLink>
      <FooterNavLink to="/catalog" text="Full catalog"/>
      <FooterNavLink to="/about" text="About us"/>
      <FooterNavLink to="/contact-us" text="Contact"/>
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

function Divider({className}) {
  return (
    <div className={"w-px self-stretch " + className} style={{ backgroundColor: "#5A5A5A" }} />
  );
}
