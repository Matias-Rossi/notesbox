import React from 'react'

function FooterLogo() {
    const style = {
        backgroundImage: `url(assets/images/brand/notesbox_footer_logo.png)`,
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