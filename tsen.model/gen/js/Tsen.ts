module tsen {
    export interface Activity extends org.kevoree.modeling.api.KObject {

        getHour(): string;

        setHour(p_obj: string): tsen.Activity;

        getTargetTemperature(): number;

        setTargetTemperature(p_obj: number): tsen.Activity;

        view(): tsen.TsenView;

    }

    export interface Room extends org.kevoree.modeling.api.KObject {

        getName(): string;

        setName(p_obj: string): tsen.Room;

        addMeasurement(p_obj: tsen.Sensor): tsen.Room;

        removeMeasurement(p_obj: tsen.Sensor): tsen.Room;

        getMeasurement(p_callback: (p : tsen.Sensor[]) => void): void;

        taskGetMeasurement(): org.kevoree.modeling.api.KTask<any>;

        sizeOfMeasurement(): number;

        addMembers(p_obj: tsen.User): tsen.Room;

        removeMembers(p_obj: tsen.User): tsen.Room;

        getMembers(p_callback: (p : tsen.User[]) => void): void;

        taskGetMembers(): org.kevoree.modeling.api.KTask<any>;

        sizeOfMembers(): number;

        addLesson(p_obj: tsen.Activity): tsen.Room;

        removeLesson(p_obj: tsen.Activity): tsen.Room;

        getLesson(p_callback: (p : tsen.Activity[]) => void): void;

        taskGetLesson(): org.kevoree.modeling.api.KTask<any>;

        sizeOfLesson(): number;

        view(): tsen.TsenView;

    }

    export interface Sensor extends org.kevoree.modeling.api.KObject {

        getGroupAddress(): string;

        setGroupAddress(p_obj: string): tsen.Sensor;

        getSensorType(): string;

        setSensorType(p_obj: string): tsen.Sensor;

        getAssociatedDPT(): string;

        setAssociatedDPT(p_obj: string): tsen.Sensor;

        getScale(): string;

        setScale(p_obj: string): tsen.Sensor;

        getValue(): string;

        setValue(p_obj: string): tsen.Sensor;

        getSensorId(): string;

        setSensorId(p_obj: string): tsen.Sensor;

        view(): tsen.TsenView;

    }

    export class TsenModel extends org.kevoree.modeling.api.abs.AbstractKModel<any> {

        private _metaModel: org.kevoree.modeling.api.meta.MetaModel;
        constructor() {
            super();
            this._metaModel = new org.kevoree.modeling.api.abs.AbstractMetaModel("Tsen", -1);
            var tempMetaClasses: org.kevoree.modeling.api.meta.MetaClass[] = new Array();
            tempMetaClasses[0] = tsen.meta.MetaRoom.getInstance();
            tempMetaClasses[2] = tsen.meta.MetaActivity.getInstance();
            tempMetaClasses[1] = tsen.meta.MetaSensor.getInstance();
            tempMetaClasses[3] = tsen.meta.MetaUser.getInstance();
            (<org.kevoree.modeling.api.abs.AbstractMetaModel>this._metaModel).init(tempMetaClasses);
        }

        public internal_create(key: number): tsen.TsenUniverse {
            return new tsen.TsenUniverse(this, key);
        }

        public metaModel(): org.kevoree.modeling.api.meta.MetaModel {
            return this._metaModel;
        }

    }

    export class TsenUniverse extends org.kevoree.modeling.api.abs.AbstractKUniverse<any, any, any> {

        constructor(p_model: org.kevoree.modeling.api.KModel<any>, key: number) {
            super(p_model, key);
        }

        public internal_create(timePoint: number): tsen.TsenView {
            return new tsen.impl.TsenViewImpl(timePoint, <org.kevoree.modeling.api.abs.AbstractKUniverse<any, any, any>>this);
        }

    }

    export interface TsenView extends org.kevoree.modeling.api.KView {

        createRoom(): tsen.Room;

        createActivity(): tsen.Activity;

        createSensor(): tsen.Sensor;

        createUser(): tsen.User;

        universe(): tsen.TsenUniverse;

    }

    export interface User extends org.kevoree.modeling.api.KObject {

        getTargetTemp(): number;

        setTargetTemp(p_obj: number): tsen.User;

        getSurname(): string;

        setSurname(p_obj: string): tsen.User;

        getName(): string;

        setName(p_obj: string): tsen.User;

        getId(): string;

        setId(p_obj: string): tsen.User;

        view(): tsen.TsenView;

    }

    export module impl {
        export class ActivityImpl extends org.kevoree.modeling.api.abs.AbstractKObject implements tsen.Activity {

            constructor(p_factory: tsen.TsenView, p_uuid: number, p_timeTree: org.kevoree.modeling.api.time.TimeTree, p_metaClass: org.kevoree.modeling.api.meta.MetaClass) {
                super(p_factory, p_uuid, p_timeTree, p_metaClass);
            }

            public getHour(): string {
                return <string>this.get(tsen.meta.MetaActivity.ATT_HOUR);
            }

            public setHour(p_obj: string): tsen.Activity {
                this.set(tsen.meta.MetaActivity.ATT_HOUR, p_obj);
                return this;
            }

            public getTargetTemperature(): number {
                return <number>this.get(tsen.meta.MetaActivity.ATT_TARGETTEMPERATURE);
            }

            public setTargetTemperature(p_obj: number): tsen.Activity {
                this.set(tsen.meta.MetaActivity.ATT_TARGETTEMPERATURE, p_obj);
                return this;
            }

            public view(): tsen.TsenView {
                return <tsen.TsenView>super.view();
            }

        }

        export class RoomImpl extends org.kevoree.modeling.api.abs.AbstractKObject implements tsen.Room {

            constructor(p_factory: tsen.TsenView, p_uuid: number, p_timeTree: org.kevoree.modeling.api.time.TimeTree, p_metaClass: org.kevoree.modeling.api.meta.MetaClass) {
                super(p_factory, p_uuid, p_timeTree, p_metaClass);
            }

            public getName(): string {
                return <string>this.get(tsen.meta.MetaRoom.ATT_NAME);
            }

            public setName(p_obj: string): tsen.Room {
                this.set(tsen.meta.MetaRoom.ATT_NAME, p_obj);
                return this;
            }

            public addMeasurement(p_obj: tsen.Sensor): tsen.Room {
                this.mutate(org.kevoree.modeling.api.KActionType.ADD, tsen.meta.MetaRoom.REF_MEASUREMENT, p_obj);
                return this;
            }

            public removeMeasurement(p_obj: tsen.Sensor): tsen.Room {
                this.mutate(org.kevoree.modeling.api.KActionType.REMOVE, tsen.meta.MetaRoom.REF_MEASUREMENT, p_obj);
                return this;
            }

            public getMeasurement(p_callback: (p : tsen.Sensor[]) => void): void {
                this.all(tsen.meta.MetaRoom.REF_MEASUREMENT,  (kObjects : org.kevoree.modeling.api.KObject[]) => {
                    if (p_callback != null) {
                        var casted: tsen.Sensor[] = new Array();
                        for (var i: number = 0; i < kObjects.length; i++) {
                            casted[i] = <tsen.Sensor>kObjects[i];
                        }
                        p_callback(casted);
                    }
                });
            }

            public taskGetMeasurement(): org.kevoree.modeling.api.KTask<any> {
                var task: org.kevoree.modeling.api.abs.AbstractKTaskWrapper<any> = new org.kevoree.modeling.api.abs.AbstractKTaskWrapper<any>();
                this.getMeasurement(task.initCallback());
                return task;
            }

            public sizeOfMeasurement(): number {
                return this.size(tsen.meta.MetaRoom.REF_MEASUREMENT);
            }

            public addMembers(p_obj: tsen.User): tsen.Room {
                this.mutate(org.kevoree.modeling.api.KActionType.ADD, tsen.meta.MetaRoom.REF_MEMBERS, p_obj);
                return this;
            }

            public removeMembers(p_obj: tsen.User): tsen.Room {
                this.mutate(org.kevoree.modeling.api.KActionType.REMOVE, tsen.meta.MetaRoom.REF_MEMBERS, p_obj);
                return this;
            }

            public getMembers(p_callback: (p : tsen.User[]) => void): void {
                this.all(tsen.meta.MetaRoom.REF_MEMBERS,  (kObjects : org.kevoree.modeling.api.KObject[]) => {
                    if (p_callback != null) {
                        var casted: tsen.User[] = new Array();
                        for (var i: number = 0; i < kObjects.length; i++) {
                            casted[i] = <tsen.User>kObjects[i];
                        }
                        p_callback(casted);
                    }
                });
            }

            public taskGetMembers(): org.kevoree.modeling.api.KTask<any> {
                var task: org.kevoree.modeling.api.abs.AbstractKTaskWrapper<any> = new org.kevoree.modeling.api.abs.AbstractKTaskWrapper<any>();
                this.getMembers(task.initCallback());
                return task;
            }

            public sizeOfMembers(): number {
                return this.size(tsen.meta.MetaRoom.REF_MEMBERS);
            }

            public addLesson(p_obj: tsen.Activity): tsen.Room {
                this.mutate(org.kevoree.modeling.api.KActionType.ADD, tsen.meta.MetaRoom.REF_LESSON, p_obj);
                return this;
            }

            public removeLesson(p_obj: tsen.Activity): tsen.Room {
                this.mutate(org.kevoree.modeling.api.KActionType.REMOVE, tsen.meta.MetaRoom.REF_LESSON, p_obj);
                return this;
            }

            public getLesson(p_callback: (p : tsen.Activity[]) => void): void {
                this.all(tsen.meta.MetaRoom.REF_LESSON,  (kObjects : org.kevoree.modeling.api.KObject[]) => {
                    if (p_callback != null) {
                        var casted: tsen.Activity[] = new Array();
                        for (var i: number = 0; i < kObjects.length; i++) {
                            casted[i] = <tsen.Activity>kObjects[i];
                        }
                        p_callback(casted);
                    }
                });
            }

            public taskGetLesson(): org.kevoree.modeling.api.KTask<any> {
                var task: org.kevoree.modeling.api.abs.AbstractKTaskWrapper<any> = new org.kevoree.modeling.api.abs.AbstractKTaskWrapper<any>();
                this.getLesson(task.initCallback());
                return task;
            }

            public sizeOfLesson(): number {
                return this.size(tsen.meta.MetaRoom.REF_LESSON);
            }

            public view(): tsen.TsenView {
                return <tsen.TsenView>super.view();
            }

        }

        export class SensorImpl extends org.kevoree.modeling.api.abs.AbstractKObject implements tsen.Sensor {

            constructor(p_factory: tsen.TsenView, p_uuid: number, p_timeTree: org.kevoree.modeling.api.time.TimeTree, p_metaClass: org.kevoree.modeling.api.meta.MetaClass) {
                super(p_factory, p_uuid, p_timeTree, p_metaClass);
            }

            public getGroupAddress(): string {
                return <string>this.get(tsen.meta.MetaSensor.ATT_GROUPADDRESS);
            }

            public setGroupAddress(p_obj: string): tsen.Sensor {
                this.set(tsen.meta.MetaSensor.ATT_GROUPADDRESS, p_obj);
                return this;
            }

            public getSensorType(): string {
                return <string>this.get(tsen.meta.MetaSensor.ATT_SENSORTYPE);
            }

            public setSensorType(p_obj: string): tsen.Sensor {
                this.set(tsen.meta.MetaSensor.ATT_SENSORTYPE, p_obj);
                return this;
            }

            public getAssociatedDPT(): string {
                return <string>this.get(tsen.meta.MetaSensor.ATT_ASSOCIATEDDPT);
            }

            public setAssociatedDPT(p_obj: string): tsen.Sensor {
                this.set(tsen.meta.MetaSensor.ATT_ASSOCIATEDDPT, p_obj);
                return this;
            }

            public getScale(): string {
                return <string>this.get(tsen.meta.MetaSensor.ATT_SCALE);
            }

            public setScale(p_obj: string): tsen.Sensor {
                this.set(tsen.meta.MetaSensor.ATT_SCALE, p_obj);
                return this;
            }

            public getValue(): string {
                return <string>this.get(tsen.meta.MetaSensor.ATT_VALUE);
            }

            public setValue(p_obj: string): tsen.Sensor {
                this.set(tsen.meta.MetaSensor.ATT_VALUE, p_obj);
                return this;
            }

            public getSensorId(): string {
                return <string>this.get(tsen.meta.MetaSensor.ATT_SENSORID);
            }

            public setSensorId(p_obj: string): tsen.Sensor {
                this.set(tsen.meta.MetaSensor.ATT_SENSORID, p_obj);
                return this;
            }

            public view(): tsen.TsenView {
                return <tsen.TsenView>super.view();
            }

        }

        export class TsenViewImpl extends org.kevoree.modeling.api.abs.AbstractKView implements tsen.TsenView {

            constructor(p_now: number, p_universe: org.kevoree.modeling.api.KUniverse<any, any, any>) {
                super(p_now, p_universe);
            }

            public internalCreate(p_clazz: org.kevoree.modeling.api.meta.MetaClass, p_timeTree: org.kevoree.modeling.api.time.TimeTree, p_key: number): org.kevoree.modeling.api.KObject {
                if (p_clazz == null) {
                    return null;
                }
                switch (p_clazz.index()) {
                    case 0: 
                    return new tsen.impl.RoomImpl(this, p_key, p_timeTree, p_clazz);
                    case 2: 
                    return new tsen.impl.ActivityImpl(this, p_key, p_timeTree, p_clazz);
                    case 1: 
                    return new tsen.impl.SensorImpl(this, p_key, p_timeTree, p_clazz);
                    case 3: 
                    return new tsen.impl.UserImpl(this, p_key, p_timeTree, p_clazz);
                    default: 
                    return new org.kevoree.modeling.api.reflexive.DynamicKObject(this, p_key, p_timeTree, p_clazz);
                }
            }

            public createRoom(): tsen.Room {
                return <tsen.Room>this.create(tsen.meta.MetaRoom.getInstance());
            }

            public createActivity(): tsen.Activity {
                return <tsen.Activity>this.create(tsen.meta.MetaActivity.getInstance());
            }

            public createSensor(): tsen.Sensor {
                return <tsen.Sensor>this.create(tsen.meta.MetaSensor.getInstance());
            }

            public createUser(): tsen.User {
                return <tsen.User>this.create(tsen.meta.MetaUser.getInstance());
            }

            public universe(): tsen.TsenUniverse {
                return <tsen.TsenUniverse>super.universe();
            }

        }

        export class UserImpl extends org.kevoree.modeling.api.abs.AbstractKObject implements tsen.User {

            constructor(p_factory: tsen.TsenView, p_uuid: number, p_timeTree: org.kevoree.modeling.api.time.TimeTree, p_metaClass: org.kevoree.modeling.api.meta.MetaClass) {
                super(p_factory, p_uuid, p_timeTree, p_metaClass);
            }

            public getTargetTemp(): number {
                return <number>this.get(tsen.meta.MetaUser.ATT_TARGETTEMP);
            }

            public setTargetTemp(p_obj: number): tsen.User {
                this.set(tsen.meta.MetaUser.ATT_TARGETTEMP, p_obj);
                return this;
            }

            public getSurname(): string {
                return <string>this.get(tsen.meta.MetaUser.ATT_SURNAME);
            }

            public setSurname(p_obj: string): tsen.User {
                this.set(tsen.meta.MetaUser.ATT_SURNAME, p_obj);
                return this;
            }

            public getName(): string {
                return <string>this.get(tsen.meta.MetaUser.ATT_NAME);
            }

            public setName(p_obj: string): tsen.User {
                this.set(tsen.meta.MetaUser.ATT_NAME, p_obj);
                return this;
            }

            public getId(): string {
                return <string>this.get(tsen.meta.MetaUser.ATT_ID);
            }

            public setId(p_obj: string): tsen.User {
                this.set(tsen.meta.MetaUser.ATT_ID, p_obj);
                return this;
            }

            public view(): tsen.TsenView {
                return <tsen.TsenView>super.view();
            }

        }

    }
    export module meta {
        export class MetaActivity extends org.kevoree.modeling.api.abs.AbstractMetaClass {

            private static INSTANCE: tsen.meta.MetaActivity = null;
            public static ATT_HOUR: org.kevoree.modeling.api.meta.MetaAttribute = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("hour", 5, 0, true, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.STRING, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());
            public static ATT_TARGETTEMPERATURE: org.kevoree.modeling.api.meta.MetaAttribute = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("targetTemperature", 6, 0, false, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.DOUBLE, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());
            public static getInstance(): tsen.meta.MetaActivity {
                if (MetaActivity.INSTANCE == null) {
                    MetaActivity.INSTANCE = new tsen.meta.MetaActivity();
                }
                return MetaActivity.INSTANCE;
            }

            constructor() {
                super("tsen.Activity", 2);
                var temp_attributes: org.kevoree.modeling.api.meta.MetaAttribute[] = new Array();
                temp_attributes[0] = MetaActivity.ATT_HOUR;
                temp_attributes[1] = MetaActivity.ATT_TARGETTEMPERATURE;
                var temp_references: org.kevoree.modeling.api.meta.MetaReference[] = new Array();
                var temp_operations: org.kevoree.modeling.api.meta.MetaOperation[] = new Array();
                this.init(temp_attributes, temp_references, temp_operations);
            }

        }

        export class MetaRoom extends org.kevoree.modeling.api.abs.AbstractMetaClass {

            private static INSTANCE: tsen.meta.MetaRoom = null;
            public static ATT_NAME: org.kevoree.modeling.api.meta.MetaAttribute = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("name", 5, 0, true, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.STRING, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());
            public static REF_MEASUREMENT: org.kevoree.modeling.api.meta.MetaReference = new org.kevoree.modeling.api.abs.AbstractMetaReference("Measurement", 6, true, false,  () => {
                return tsen.meta.MetaSensor.getInstance();
            }, null,  () => {
                return tsen.meta.MetaRoom.getInstance();
            });
            public static REF_MEMBERS: org.kevoree.modeling.api.meta.MetaReference = new org.kevoree.modeling.api.abs.AbstractMetaReference("members", 7, true, false,  () => {
                return tsen.meta.MetaUser.getInstance();
            }, null,  () => {
                return tsen.meta.MetaRoom.getInstance();
            });
            public static REF_LESSON: org.kevoree.modeling.api.meta.MetaReference = new org.kevoree.modeling.api.abs.AbstractMetaReference("lesson", 8, true, false,  () => {
                return tsen.meta.MetaActivity.getInstance();
            }, null,  () => {
                return tsen.meta.MetaRoom.getInstance();
            });
            public static getInstance(): tsen.meta.MetaRoom {
                if (MetaRoom.INSTANCE == null) {
                    MetaRoom.INSTANCE = new tsen.meta.MetaRoom();
                }
                return MetaRoom.INSTANCE;
            }

            constructor() {
                super("tsen.Room", 0);
                var temp_attributes: org.kevoree.modeling.api.meta.MetaAttribute[] = new Array();
                temp_attributes[0] = MetaRoom.ATT_NAME;
                var temp_references: org.kevoree.modeling.api.meta.MetaReference[] = new Array();
                temp_references[0] = MetaRoom.REF_MEASUREMENT;
                temp_references[1] = MetaRoom.REF_MEMBERS;
                temp_references[2] = MetaRoom.REF_LESSON;
                var temp_operations: org.kevoree.modeling.api.meta.MetaOperation[] = new Array();
                this.init(temp_attributes, temp_references, temp_operations);
            }

        }

        export class MetaSensor extends org.kevoree.modeling.api.abs.AbstractMetaClass {

            private static INSTANCE: tsen.meta.MetaSensor = null;
            public static ATT_GROUPADDRESS: org.kevoree.modeling.api.meta.MetaAttribute = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("groupAddress", 5, 0, true, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.STRING, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());
            public static ATT_SENSORTYPE: org.kevoree.modeling.api.meta.MetaAttribute = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("sensorType", 6, 0, false, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.STRING, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());
            public static ATT_ASSOCIATEDDPT: org.kevoree.modeling.api.meta.MetaAttribute = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("associatedDPT", 7, 0, false, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.STRING, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());
            public static ATT_SCALE: org.kevoree.modeling.api.meta.MetaAttribute = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("scale", 8, 0, false, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.STRING, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());
            public static ATT_VALUE: org.kevoree.modeling.api.meta.MetaAttribute = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("value", 9, 0, false, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.STRING, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());
            public static ATT_SENSORID: org.kevoree.modeling.api.meta.MetaAttribute = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("sensorId", 10, 0, false, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.STRING, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());
            public static getInstance(): tsen.meta.MetaSensor {
                if (MetaSensor.INSTANCE == null) {
                    MetaSensor.INSTANCE = new tsen.meta.MetaSensor();
                }
                return MetaSensor.INSTANCE;
            }

            constructor() {
                super("tsen.Sensor", 1);
                var temp_attributes: org.kevoree.modeling.api.meta.MetaAttribute[] = new Array();
                temp_attributes[0] = MetaSensor.ATT_GROUPADDRESS;
                temp_attributes[1] = MetaSensor.ATT_SENSORTYPE;
                temp_attributes[2] = MetaSensor.ATT_ASSOCIATEDDPT;
                temp_attributes[3] = MetaSensor.ATT_SCALE;
                temp_attributes[4] = MetaSensor.ATT_VALUE;
                temp_attributes[5] = MetaSensor.ATT_SENSORID;
                var temp_references: org.kevoree.modeling.api.meta.MetaReference[] = new Array();
                var temp_operations: org.kevoree.modeling.api.meta.MetaOperation[] = new Array();
                this.init(temp_attributes, temp_references, temp_operations);
            }

        }

        export class MetaUser extends org.kevoree.modeling.api.abs.AbstractMetaClass {

            private static INSTANCE: tsen.meta.MetaUser = null;
            public static ATT_TARGETTEMP: org.kevoree.modeling.api.meta.MetaAttribute = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("targetTemp", 5, 0, false, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.DOUBLE, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());
            public static ATT_SURNAME: org.kevoree.modeling.api.meta.MetaAttribute = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("surname", 6, 0, false, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.STRING, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());
            public static ATT_NAME: org.kevoree.modeling.api.meta.MetaAttribute = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("name", 7, 0, false, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.STRING, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());
            public static ATT_ID: org.kevoree.modeling.api.meta.MetaAttribute = new org.kevoree.modeling.api.abs.AbstractMetaAttribute("id", 8, 0, true, org.kevoree.modeling.api.meta.PrimitiveMetaTypes.STRING, org.kevoree.modeling.api.extrapolation.DiscreteExtrapolation.instance());
            public static getInstance(): tsen.meta.MetaUser {
                if (MetaUser.INSTANCE == null) {
                    MetaUser.INSTANCE = new tsen.meta.MetaUser();
                }
                return MetaUser.INSTANCE;
            }

            constructor() {
                super("tsen.User", 3);
                var temp_attributes: org.kevoree.modeling.api.meta.MetaAttribute[] = new Array();
                temp_attributes[0] = MetaUser.ATT_TARGETTEMP;
                temp_attributes[1] = MetaUser.ATT_SURNAME;
                temp_attributes[2] = MetaUser.ATT_NAME;
                temp_attributes[3] = MetaUser.ATT_ID;
                var temp_references: org.kevoree.modeling.api.meta.MetaReference[] = new Array();
                var temp_operations: org.kevoree.modeling.api.meta.MetaOperation[] = new Array();
                this.init(temp_attributes, temp_references, temp_operations);
            }

        }

    }
}
