### LibGdx_games,  GeekBrains:  Fansil, Tutorial: https://libgdx.com/wiki/

tools - texturepacker-gui (утилита упаковщика текстур http://www.libgdx.ru/2015/01/texture-packer.html)

### Classes

- class Ship - описание объекта Ship.
- class Hero - extends Ship + описание объекта Hero. 
- class Background - описание объекта Background.
- class Asteroid  описание объекта Asteroid.
- class AsteroidController - подключаем класс Asteroid и описываем логику работы объекта Asteroid (что он должен делать).
- class Bullet - описание объекта пуля.
- class BulletController - подключаем класс Bullet и описываем логику работы объекта Bullet (что он должен делать).
- class Weapon - описание объекта Weapon (Оружие).
- class WeaponRendering - отрисовка оружия.
- class PowerUp - описание объекта (добавление в игру всяких нäшек таких как, пополнение жизни, монетки и т.д). 
- class PowerUpController- подключаем класс PowerUp и описываем логику работы объекта PowerUp (что он должен делать).
- class Shop - описание объекта Shop.
- class InfoText - описывает свой цвет и свое местоположение на экране.
- class InfoController - подключаем класс PowerUp и описываем логику работы объекта PowerUp (что он должен делать).
- class GameController - это как хаб для всех контроллеров (описываем логику взаимодействия) и потом передает на отрисовку классу WorldRenderer.
- class WorldRenderer: занимается рисованием (method render()) игровых объектов  (т.к Hero, Background, Bullet ....).

screen/
- class AbstractScreen -
- class GameOver -
- class GameScreen -
- class LoadingScreen -
- class ScreenManager - Менеджер управление экранами (pattern Singleton)
- 
### utility classes

- class Assets - управление текстурами Atlas (pattern Singleton).
- class Particle - описание частицы.
- class ParticleController - создание эффектов с помощью частиц (render() работа с эффектами цветовой гаммы).
- class ObjectPool - pattern ObjectPool.
- Описание: B нем два массива для хранения игровых объектов, oдин массив - это для хранения активных игровых объектов, второй - для не активных игровых объектов.
  
  Пример: Когда игровой объект (Asteroid, Bullet, ... ) вылетает за экран он становится не активным и он кладется в массив не активных объектов.
  Потом он переводится в массив активных объектов и может использоваться в игре снова.


### для подключения игрового объекта нужно:

1. создаем класс и описываем его. (пример class Hero, Star, Background, Asteroid, Bullet, Weapon...  )
2. подключаем этот класс к контроллеру игровых объектов GamesController и описывает взаимодействие с другими объектами
3. отдаем класс GamesController на отрисовку классу WorldRenderer.

 WorldRenderer: занимается рисованием (method render()) игровых объектов  (т.к Hero, Background, Bullet....).



 


