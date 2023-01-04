import React from 'react'

function FooterLogo() {
    const style = {
        backgroundImage: `url(../src/assets/brand/notesbox-footer-logo.png)`,
        backgroundSize: "contain",
        backgroundRepeat: "no-repeat",
        width: "60%",
        height: "0",
        paddingTop: "20%"

    }
  return (
    <div style={style} />
  )
}

export default FooterLogo