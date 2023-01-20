import React from 'react'

function SmallLogo() {
    const style = {
        backgroundImage: `url(assets/images/brand/notesbox_biglogo.png)`,
        backgroundSize: "contain",
        backgroundRepeat: "no-repeat",
        width: "100%",
        height: "0",
        paddingTop: "30.86%"

    }
  return (
    <div style={style} />
  )
}

export default SmallLogo