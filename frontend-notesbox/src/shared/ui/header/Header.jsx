import React from "react";
import { Link } from "react-router-dom";
import SmallLogo from "~/shared/ui/SmallLogo";

function Header() {

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
    <header className="flex flex-col items-center border-b-2 border-black sticky top-0 bg-white">
      <div className="flex flex-row justify-between w-full px-32 my-2 items-center">
        <Link style={{ width: "139px" }} to={"/"}>
          <SmallLogo />
        </Link>
        <ul className="h-full flex">
          {
            navButtons.map((nav, i) => <HeaderNavButton text={nav.text} to={nav.to} key={i}/>)
          }
        </ul>
        
        {/* TODO: Add login */}
      
      </div>
    </header>
  );
}

export default Header;


function HeaderNavButton({text, to}) {
  return (
    <Link to={to} className="sans text-black h-full hover:underline ease-in-out">
      <div className="px-3 py-2">
        {text}
      </div>
    </Link>
  )
}


