import React from "react";
import { Link } from "react-router-dom";
import SmallLogo from "~/shared/ui/SmallLogo";
import { useMediaQuery } from "react-responsive";
import { FaBars, FaUserCircle } from "react-icons/fa";
import { useLocation } from "react-router-dom";


function Header({toggleSidebar}) {

  const isMobile = useMediaQuery({ query: "(max-width: 639px)" });
  const shouldHide = useLocation().pathname === "/login";

  const navButtons = [
    {
      text: "Home",
      to: "/"
    },
    {
      text: "Full catalog",
      to: "/catalog"
    },
    {
      text: "About us",
      to: "/about"
    }
  ];


  return (
    <header className={`flex flex-col items-center border-b-2 border-black sticky top-0 bg-white z-10 ${shouldHide? "hidden" : ""}`}>
      <div className="flex flex-row justify-between w-full px-32 my-2 items-center sm:px-5 lg:px-12">
        <Link style={{ width: "139px" }} to={"/"}>
          <SmallLogo />
        </Link>
        {isMobile && <FaBars className="block absolute top-0 right-0 text-3xl cursor-pointer" style={{transform: "translate(-40%,40%)"}} onClick={toggleSidebar}/>}
        { !isMobile &&
          <ul className="h-full flex">
          {
            navButtons.map((nav, i) => <HeaderNavButton text={nav.text} to={nav.to} key={i}/>)
          }
          {/* TODO: Add login and logged in alternative */}
          <HeaderNavButton icon={<FaUserCircle className="text-black-75 text-2xl"/>} text="Log in" to="/login" />
        </ul>}
        
      
      </div>
    </header>
  );
}

export default Header;


function HeaderNavButton({text, to, icon}) {
  return (
    <Link to={to} className="sans text-black h-full center hover:underline ease-in-out">
      <div className="px-3 py-2 flex justify-start items-center gap-2">
        {icon}{text}
      </div>
    </Link>
  )
}


