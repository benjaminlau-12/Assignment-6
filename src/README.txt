@author Angela Shen
Assignment 5 Design Overview:

~cs3500.animator.model
IAnimationModel: Interface that represents an animation model. Includes methods such as setBounds(),
                 addShape(), etc. that allows the client to manipulate the current animation canvas.
                 Might need further encapsulation.
AnimationModel:  Class that implements IAnimationModel and represents the model we will use for
                 animations. Aside from all inherited methods, AnimationModel also includes a
                 toString() method that allows the client to view the animation process in text.
Command:         Class representing a command given by the client. Includes a starting and ending
                 time of the command. Also includes the starting and ending information of the
                 given shape before and after a command.
~.shapes
IShape:          Interface that represents a shape, which is either an ellipse or a rectangle.
                 Includes setter methods that allows the client to manipulate information regarding
                 the created shapes.
Shape:           Class that implements IShape and represents a shape used in our animations.
                 Includes setter methods that allows the client to manipulate information regarding
                 the created shapes.
Rectangle:       One type of the Shape objects.
Ellipse:         One type of the Shape objects. Has fields cx and cy alongside the radii that
                 specifies the positions of the radii.