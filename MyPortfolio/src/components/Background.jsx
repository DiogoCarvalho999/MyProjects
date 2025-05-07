import { useCallback } from "react";
import Particles from "react-tsparticles";
import { loadSlim } from "tsparticles-slim";

const Background = ({ darkMode }) => {
  const particlesInit = useCallback(async (engine) => {
    await loadSlim(engine);
  }, []);

  return (
    <Particles
      id="tsparticles"
      init={particlesInit}
      options={{
        fullScreen: { enable: true, zIndex: -1 },
        background: {
          color: { value: darkMode ? "#0f172a" : "#ffffff" },
        },
        particles: {
          number: { value: 60, density: { enable: true, area: 800 } },
          color: { value: "#3b82f6" },
          links: {
            enable: true,
            color: "#60a5fa",
            distance: 150,
            opacity: 0.3,
            width: 1,
          },
          move: { enable: true, speed: 1 },
          size: { value: { min: 1, max: 3 } },
          opacity: { value: 0.5 },
        },
        interactivity: {
          events: {
            onHover: {
              enable: true,
              mode: "repulse",
            },
          },
        },
      }}
    />
  );
};

export default Background;
