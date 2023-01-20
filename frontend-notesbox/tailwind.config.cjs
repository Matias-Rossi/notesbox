/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    colors: {
      'primary': 'rgba(167, 110, 255, 1)',
      'secondary': 'rgba(199, 170, 246, 1)',
      'pressed': 'rgba(104, 42, 200, 1)',
      'black': 'rgba(33, 22, 51, 1)',
      'black-75': 'rgba(19, 12, 29, 0.75)',
      'black-50': 'rgba(19, 12, 29, 0.5)',
      'black-25': 'rgba(19, 12, 29, 0.25)',
      'black-10': 'rgba(19, 12, 29, 0.1)',
      'black-5': 'rgba(19, 12, 29, 0.05)',
      'white': 'rgba(250, 248, 253, 1)',
    },
    extend: {
      backgroundImage: {
        'gradient-radial': 'radial-gradient(25.66% 75.42% at 50% 50%, #b486ff 0%, #AA73FF 100%)',
      }
    },
    screens: {
			xl: { max: "1279px" },
			// => @media (max-width: 1279px) { ... }

			lg: { max: "1023px" },
			// => @media (max-width: 1023px) { ... }

			md: { max: "767px" },
			// => @media (max-width: 767px) { ... }

			sm: { max: "639px" },
			// => @media (max-width: 639px) { ... }
		},
  },
  plugins: [],
}
