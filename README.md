### LibGdx_games,  GeekBrains:  Fansil

tools - texturepacker-gui (утилита упаковщикa текстур)

### Classes

- class Hero - описание объекта Hero
- class Background - описание объекта Background
- class Asteroid  описание объекта Asteroid
- class AsteroidController - подключаем класс Asteroid и описываем логику работы объекта Asteroid (что он должен делать)
- class Bullet - описание объекта пуля
- class BulletController - подключаем класс Bullet и описываем логику работы объекта Bullet (что он должен делать)
- class Weapon - описание объекта Weapon (Оружие)
- class WeaponRendering - отрисовка оружия
- class PowerUp - описание объекта (дабление в игру всяких нäшек, таких как пополнение жизни, монетки и т.д ) 
- class PowerUpConroller- подключаем класс PowerUp и описываем логику работы объекта PowerUp (что он должен делать)
- class GameController - подключаем нужные классы и описываем логику взаимодействия с другими объектами

### utility classes

- class Assets - управление текстурами Atlas (pattern Singleton)
- class Particle - описание частицы
- class ParticleController - создание эффектов с помощью частиц (render() работа с эффектами цветовой гаммы )
- class ObjectPool - pattern ObjectPool
- class ScreenManager - Менеджер управление экранами (pattern Singleton)

  B нем два массива для хранения игровых объектов, oдин массив - это для хранения активных игровых объектов, второй - для не активных игровых объектов
  Пример.  Когда игровой объект (Asteroid или Bullet) вылетает за экран он становится не активным  
  и кладется в массив не активных объектов. Потом он переводится в массив активных объектов и может использоваться в игре снова.

- class WorldRenderer: занимается рисованием (method render()) игровых объектов  (т.к Hero, Background, Bullet, ....).

### для подключения игровых  объекта нужно:

1. создаем класс и описываем его. (пример class Hero, Star, Background, Asteroid, Bullet, Weapon,  )
2. подключаем этот класс к контроллеру игровых объектов GamesController и описывает взаимодействие с другими объектами
3. отдаем класс GamesController на отрисовку классу WorldRenderer.


WorldRenderer: занимается рисованием (method render()) игровых объектов  (т.к Hero, Background, Bullet, ....).



 


